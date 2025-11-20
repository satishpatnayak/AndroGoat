package owasp.sat.agoat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ContentProviderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        val username = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val cpViewButton = findViewById<Button>(R.id.CPViewButton)

        cpViewButton.setOnClickListener{
            // In a real app, you would do something with the username and password
        }
    }
}
