package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.*
import java.util.*

class InsecureStorageSDCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage_sdcard)

        val SaveButton=findViewById<Button>(R.id.SDcardSaveButton)
        val username =findViewById<EditText>(R.id.userName);
        val password= findViewById<EditText>(R.id.password);

        SaveButton.setOnClickListener{
            try {
                val data:String=" This data is stored in SdCard on "+ Date()+": \n Username - " + username.text.toString() + " Password -" + password.text.toString()+"\n";
            val userinfo = File.createTempFile("users", "tmp", File(Environment.getExternalStorageDirectory().absolutePath))
                println("userinfo " +userinfo)
            userinfo.setReadable(true)
            userinfo.setWritable(true)
            val fw = FileWriter(userinfo)
            fw.write(data);
            //fw.write("password is " +password.text.toString()+ "\n");
            fw.close();
                Toast.makeText(applicationContext, "Data saved", Toast.LENGTH_LONG).show();
           }
           catch (e: IOException)
           {
              e.printStackTrace()
           }
        }
    }
}
