package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insecure_logging.*

class KeyboardCacheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyboard_cache)
        val username=findViewById<EditText>(R.id.userName);
        val password=findViewById<EditText>(R.id.password);
        Logging1.setOnClickListener{
            Toast.makeText(applicationContext, "Please wait while verifying your credentials ", Toast.LENGTH_LONG).show();
        }
    }
}
