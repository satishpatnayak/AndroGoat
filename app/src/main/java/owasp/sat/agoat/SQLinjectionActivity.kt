package owasp.sat.agoat

import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception
import java.lang.StringBuilder

class SQLinjectionActivity : AppCompatActivity() {
    private var mDB: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlinjection)
        val SQLibutton=findViewById<Button>(R.id.SQLiBurron);
        val username=findViewById<EditText>(R.id.userName);


        SQLibutton.setOnClickListener{
            var qry:String="SELECT * FROM users WHERE username='"+username.text.toString()+"'";
            try {
                this.mDB = openOrCreateDatabase("aGoat", 0, null)
                val QryResult = this.mDB!!.rawQuery(qry, null)
                val strb = StringBuilder("")
                if (QryResult == null || QryResult.count <= 0) {
                    strb.append("User: ("+username.text.toString()+") not found")
                } else {
                    QryResult.moveToFirst()
                    do {
                        strb.append("Username: (" + QryResult.getString(1) + ") password: (" + QryResult.getString(2) + ")\n")
                    } while (QryResult.moveToNext())
                }
                Toast.makeText(this, strb.toString(), Toast.LENGTH_LONG).show();
                Log.e("Error:",strb.toString());
            } catch (e: Exception) {
                Log.d("Error", "Error occurred when inserting data into database: " + e.message)
                Toast.makeText(applicationContext, "Data not saved: Error occured - " + e.message, Toast.LENGTH_LONG).show();
            }
            Log.v("Query",qry);

        }


    }

    
}
