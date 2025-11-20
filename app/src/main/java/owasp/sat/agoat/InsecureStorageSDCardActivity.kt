package owasp.sat.agoat

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.*
import java.util.*

class InsecureStorageSDCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage_sdcard)

<<<<<<< HEAD
        val saveButton = findViewById<Button>(R.id.SDcardSaveButton)
        val username = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Login")
        saveButton.setOnClickListener {
            if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
                try {
                    val data = "This data is stored in SdCard on ${Date()}: \n Username - ${username.text} Password -${password.text}\n"
                    val userinfo = File.createTempFile("users", "_tmp", getExternalFilesDir(null))
                    println("userinfo " +userinfo)
                    userinfo.setReadable(true)
                    userinfo.setWritable(true)
                    val fw = FileWriter(userinfo)
                    fw.write(data);
                    fw.close();
                    builder.setMessage("Username and Password are verified")
                    Toast.makeText(applicationContext, "Username and Password are verified", Toast.LENGTH_LONG).show();
                    Log.i("Info", "Data saved to"+ userinfo.absolutePath);
                } catch (e: IOException) {
                    e.printStackTrace()
                    builder.setMessage("There is an issue while verifying the username and password")
                    Toast.makeText(applicationContext, "There is an issue while verifying the username and password", Toast.LENGTH_LONG).show()
                }
            } else {
                builder.setMessage("External storage not available")
                Toast.makeText(applicationContext, "External storage not available", Toast.LENGTH_LONG).show()
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
=======
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
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
        }
    }
}
