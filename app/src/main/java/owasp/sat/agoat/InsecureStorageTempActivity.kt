package owasp.sat.agoat

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.File
import java.io.FileWriter
import java.lang.Exception

class InsecureStorageTempActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage_temp)
        val savebutton =findViewById<Button>(R.id.TempViewButton);
        val username =findViewById<EditText>(R.id.userName);
        val password= findViewById<EditText>(R.id.password);

        savebutton.setOnClickListener {
            try {
                val userinfo = File.createTempFile("users", "tmp", File(applicationInfo.dataDir))
                userinfo.setReadable(true)
                userinfo.setWritable(true)
                val fw = FileWriter(userinfo)
                fw.write("username is " + username.text.toString()+ "\n");
                fw.write("password is " +password.text.toString()+ "\n");
                fw.close();
                Toast.makeText(applicationContext, "Data saved", Toast.LENGTH_LONG).show();
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Data not saved", Toast.LENGTH_LONG).show();
                e.printStackTrace()
            }
        }

    }
}
