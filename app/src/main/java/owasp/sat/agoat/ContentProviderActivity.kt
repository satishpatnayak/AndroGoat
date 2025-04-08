package owasp.sat.agoat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import owasp.sat.agoat.databinding.ActivityContentProviderBinding

class ContentProviderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContentProviderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username=findViewById<EditText>(R.id.userName)
        val password=findViewById<EditText>(R.id.password)

        binding.CPViewButton.setOnClickListener{

        }
    }


}
