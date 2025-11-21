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
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Login")
        loggingButton.setOnClickListener {
            val logMessage = "Username: ${username.text} and Password: ${password.text} are verified"
            Log.i("Info:", logMessage)
            System.out.println(logMessage)
            builder.setMessage("Username and Password are verified")
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
            Toast.makeText(this, "Username and Password are verified", Toast.LENGTH_LONG).show()
        }
    }
}
