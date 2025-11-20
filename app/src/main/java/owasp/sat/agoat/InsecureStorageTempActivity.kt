package owasp.sat.agoat

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
=======
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
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
<<<<<<< HEAD
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Login")
=======

>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
        savebutton.setOnClickListener {
            try {
                val userinfo = File.createTempFile("users", "tmp", File(applicationInfo.dataDir))
                userinfo.setReadable(true)
                userinfo.setWritable(true)
                val fw = FileWriter(userinfo)
                fw.write("username is " + username.text.toString()+ "\n");
                fw.write("password is " +password.text.toString()+ "\n");
                fw.close();
<<<<<<< HEAD
                builder.setMessage("Username and Password are verified")
                Toast.makeText(applicationContext, "Username and Password are verified", Toast.LENGTH_LONG).show();
            } catch (e: Exception) {
                builder.setMessage("There is an issue while verifying the username and password")
                Toast.makeText(applicationContext, "There is an issue while verifying the username and password",Toast.LENGTH_LONG).show();
                e.printStackTrace()
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
=======
                Toast.makeText(applicationContext, "Data saved", Toast.LENGTH_LONG).show();
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Data not saved", Toast.LENGTH_LONG).show();
                e.printStackTrace()
            }
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
        }

    }
}
