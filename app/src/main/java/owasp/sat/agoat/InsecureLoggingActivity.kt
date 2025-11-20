package owasp.sat.agoat

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insecure_logging.*
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class InsecureLoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_logging)
<<<<<<< HEAD
        val username = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val loggingButton = findViewById<Button>(R.id.Logging1)

        loggingButton.setOnClickListener {
            val logMessage = "Error occurred when processing Username: ${username.text} and Password: ${password.text}"
            Log.e("Error:", logMessage)
            System.out.println(logMessage)
            Toast.makeText(this, "Error Occurred", Toast.LENGTH_LONG).show()
=======
        val username=findViewById<EditText>(R.id.userName);
        val password=findViewById<EditText>(R.id.password);
        Logging1.setOnClickListener{
            Log.e("Error:","Error occured when processing Username "+ username.text+"  and Password " +password.text);
            System.out.println("Error: Error occured when processing Username "+ username.text+"  and Password " +password.text);
            Toast.makeText(applicationContext, "Error Occured", Toast.LENGTH_LONG).show();
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
        }
    }
}
