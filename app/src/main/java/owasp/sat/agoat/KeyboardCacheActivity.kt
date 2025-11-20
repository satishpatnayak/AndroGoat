package owasp.sat.agoat

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insecure_logging.*
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class KeyboardCacheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyboard_cache)
<<<<<<< HEAD
        val username = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.Logging1)

        loginButton.setOnClickListener {
            Toast.makeText(applicationContext, "Please wait while verifying your credentials", Toast.LENGTH_LONG).show()
=======
        val username=findViewById<EditText>(R.id.userName);
        val password=findViewById<EditText>(R.id.password);
        Logging1.setOnClickListener{
            Toast.makeText(applicationContext, "Please wait while verifying your credentials ", Toast.LENGTH_LONG).show();
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
        }
    }
}
