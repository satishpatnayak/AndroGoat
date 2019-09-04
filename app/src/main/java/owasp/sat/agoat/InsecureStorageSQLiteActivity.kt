package owasp.sat.agoat

import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sqlinjection.*
import java.lang.Exception

class InsecureStorageSQLiteActivity : AppCompatActivity() {
    private var mDB: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.mDB = openOrCreateDatabase("aGoat", 0, null)
            this.mDB!!.execSQL("CREATE TABLE IF NOT EXISTS users (ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, username VARCHAR, password VARCHAR)");
        } catch (e: Exception) {
            Log.e("Error:", "Error occurred while creating database: " + e.message)
        }
        setContentView(R.layout.activity_insecure_storage_sqlite)

        val savebutton =findViewById<Button>(R.id.SQLButton);
        val username =findViewById<EditText>(R.id.userName);
        val password= findViewById<EditText>(R.id.password);
       // var username1:String=username.text.toString();
        //var password1:String=password.text.toString();

        savebutton.setOnClickListener{
            var qry:String="INSERT INTO users (username, password) VALUES('"+username.text.toString()+"','"+password.text.toString()+"')";

            try {
                this.mDB!!.execSQL(qry)
                //this.mDB!!.close()
                Toast.makeText(applicationContext, "Data saved", Toast.LENGTH_LONG).show();
            } catch (e: Exception) {
                Log.d("Error", "Error occurred when inserting data into database: " + e.message)
                Toast.makeText(applicationContext, "Data not saved: Error occured - " + e.message, Toast.LENGTH_LONG).show();
            }
            Log.v("Query",qry);

        }
    }
}
