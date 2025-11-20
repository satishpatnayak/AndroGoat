package owasp.sat.agoat

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class InsecureStorageSQLiteActivity : AppCompatActivity() {
    private var mDB: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            mDB = openOrCreateDatabase("aGoat", 0, null)
            mDB?.execSQL("CREATE TABLE IF NOT EXISTS users (ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, username VARCHAR, password VARCHAR)")
        } catch (e: Exception) {
            Log.e("Error:", "Error occurred while creating database: ${e.message}")
        }
        setContentView(R.layout.activity_insecure_storage_sqlite)

        val saveButton = findViewById<Button>(R.id.SQLButton)
        val username = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)

        saveButton.setOnClickListener {
            val builder = androidx.appcompat.app.AlertDialog.Builder(this)
            builder.setTitle("Login")
            val qry = "INSERT INTO users (username, password) VALUES('${username.text}','${password.text}')"

            try {
                mDB?.execSQL(qry)
                builder.setMessage("Username and Password are verified")
                Toast.makeText(applicationContext, "Username and Password are verified", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Log.d("Error", "Error occurred when inserting data into database: ${e.message}")
                builder.setMessage("There is an issue while verifying the username and password- ${e.message}")
                Toast.makeText(applicationContext, "There is an issue while verifying the username and password - ${e.message}", Toast.LENGTH_LONG).show()
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
            Log.v("Query", qry)
        }
    }
}
