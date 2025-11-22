package owasp.sat.agoat

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri
import android.text.TextUtils

class ContentProviderActivity : ContentProvider() {

    companion object {
        // Database Constants
        const val DBNAME = "androgoat_userpins.db"
        const val TABLE = "user_pins"
        const val ID = "id"
        const val USERNAME = "username"
        const val PIN = "pin"

        // Provider Constants
        const val AUTHORITY = "owasp.sat.agoat.provider.userpinsprovider"
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/$TABLE")

        const val PATH_TABLE = 1
        const val PATH_ID = 2

        val urimatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, TABLE, PATH_TABLE)
            addURI(AUTHORITY, "$TABLE/#", PATH_ID)
        }

        // SQL Queries
        const val CREATE_TBL_QRY = "CREATE TABLE $TABLE (" +
                "$ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$USERNAME TEXT NOT NULL, " +
                "$PIN TEXT NOT NULL);"

        const val DROP_TBL_QRY = "DROP TABLE IF EXISTS $TABLE"
    }

    private lateinit var mDB: SQLiteDatabase

    private class DBHelper(context: Context?) : SQLiteOpenHelper(context, DBNAME, null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(DROP_TBL_QRY)
            db.execSQL(CREATE_TBL_QRY)
            // Insert dummy sensitive data
            db.execSQL("INSERT INTO $TABLE ($USERNAME, $PIN) VALUES ('AndroGoat', 'AndroGoat');")
            db.execSQL("INSERT INTO $TABLE ($USERNAME, $PIN) VALUES ('root', 'toor');")
            db.execSQL("INSERT INTO $TABLE ($USERNAME, $PIN) VALUES ('Admin', 'Admin');")
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            onCreate(db)
        }
    }

    override fun onCreate(): Boolean {
        val dbHelper = DBHelper(context)
        mDB = dbHelper.writableDatabase
        return mDB != null
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val queryBuilder = SQLiteQueryBuilder()
        queryBuilder.tables = TABLE

        when (urimatcher.match(uri)) {
            PATH_TABLE -> {
                // No filter, returns all rows
            }
            PATH_ID -> {
                queryBuilder.appendWhere("$ID=${uri.lastPathSegment}")
            }
            else -> throw IllegalArgumentException("AndroGoat UserPinsProvider(query): Unknown URI $uri")
        }

        val orderBy = if (TextUtils.isEmpty(sortOrder)) USERNAME else sortOrder

        val cursor = queryBuilder.query(
            mDB, projection, selection, selectionArgs, null, null, orderBy
        )

        cursor.setNotificationUri(context!!.contentResolver, uri)
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val row = mDB.insert(TABLE, "", values)
        if (row > 0) {
            val newUri = ContentUris.withAppendedId(CONTENT_URI, row)
            context!!.contentResolver.notifyChange(newUri, null)
            return newUri
        }
        throw SQLException("AndroGoat UserPinsProvider: Fail to add a new record into $uri")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        var count = 0
        when (urimatcher.match(uri)) {
            PATH_TABLE -> count = mDB.delete(TABLE, selection, selectionArgs)
            PATH_ID -> {
                val id = uri.lastPathSegment
                val where = "$ID = $id" + if (!TextUtils.isEmpty(selection)) " AND ($selection)" else ""
                count = mDB.delete(TABLE, where, selectionArgs)
            }
            else -> throw IllegalArgumentException("AndroGoat UserPinsProvider(delete): Unsupported URI $uri")
        }
        context!!.contentResolver.notifyChange(uri, null)
        return count
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        var count = 0
        when (urimatcher.match(uri)) {
            PATH_TABLE -> count = mDB.update(TABLE, values, selection, selectionArgs)
            PATH_ID -> {
                val id = uri.lastPathSegment
                val where = "$ID = $id" + if (!TextUtils.isEmpty(selection)) " AND ($selection)" else ""
                count = mDB.update(TABLE, values, where, selectionArgs)
            }
            else -> throw IllegalArgumentException("AndroGoat UserPinsProvider(update): Unsupported URI $uri")
        }
        context!!.contentResolver.notifyChange(uri, null)
        return count
    }

    override fun getType(uri: Uri): String? {
        return when (urimatcher.match(uri)) {
            PATH_TABLE -> "vnd.android.cursor.dir/vnd.androgoat.pins"
            PATH_ID -> "vnd.android.cursor.item/vnd.androgoat.pins"
            else -> throw IllegalArgumentException("AndroGoat UserPinsProvider: Unsupported URI: $uri")
        }
    }
}