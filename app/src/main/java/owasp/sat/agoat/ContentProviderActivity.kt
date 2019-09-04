package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_content_provider.*

class ContentProviderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        val username=findViewById<EditText>(R.id.userName)
        val password=findViewById<EditText>(R.id.password)

        CPViewButton.setOnClickListener{

        }
    }


}
