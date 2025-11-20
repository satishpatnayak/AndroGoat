package owasp.sat.agoat

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
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
        val sqliButton=findViewById<Button>(R.id.SQLiButton)
        val username=findViewById<EditText>(R.id.userName)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Search Users")
        sqliButton.setOnClickListener{
            val qry = "SELECT * FROM users WHERE username='"+username.text+"'";
            try {
                mDB = openOrCreateDatabase("aGoat", 0, null)
                val qryResult = mDB?.rawQuery(qry, null)
                val strb = StringBuilder("")
                if (qryResult == null || qryResult.count <= 0) {
                    strb.append("User: (${username.text}) not found")
                } else {
                    qryResult.moveToFirst()
                    do {
                        strb.append("Username: (${qryResult.getString(1)}) password: (${qryResult.getString(2)})\n")
                    } while (qryResult.moveToNext())
                    qryResult.close()
                }
                builder.setMessage("Users Found:\n ${strb.toString()}")
                Toast.makeText(this, strb.toString(), Toast.LENGTH_LONG).show()
                Log.e("QueryResult",strb.toString())
            } catch (e: Exception) {
                Log.d("Error", "Error occurred when querying database: ${e.message}")
                builder.setMessage("Error occurred:\n ${e.message}")
                Toast.makeText(applicationContext, "Error occurred: ${e.message}", Toast.LENGTH_LONG).show()
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
            Log.v("Query",qry)
            mDB?.close()
        }
    }
}
