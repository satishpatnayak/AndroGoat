package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import owasp.sat.agoat.databinding.ActivityKeyboardCacheBinding

class KeyboardCacheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKeyboardCacheBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username=findViewById<EditText>(R.id.userName);
        val password=findViewById<EditText>(R.id.password);
        binding.Logging1.setOnClickListener{
            Toast.makeText(applicationContext, "Please wait while verifying your credentials ", Toast.LENGTH_LONG).show();
        }
    }
}
