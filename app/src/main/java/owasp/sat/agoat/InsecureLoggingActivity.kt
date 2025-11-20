package owasp.sat.agoat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InsecureLoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_logging)
        val username = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val loggingButton = findViewById<Button>(R.id.Logging1)

        loggingButton.setOnClickListener {
            val logMessage = "Error occurred when processing Username: ${username.text} and Password: ${password.text}"
            Log.e("Error:", logMessage)
            System.out.println(logMessage)
            Toast.makeText(this, "Error Occurred", Toast.LENGTH_LONG).show()
        }
    }
}
