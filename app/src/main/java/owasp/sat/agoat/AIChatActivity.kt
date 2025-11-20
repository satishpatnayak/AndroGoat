package owasp.sat.agoat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AIChatActivity : AppCompatActivity() {

    private val openAIApiKey = "sk-abcdef1234567890abcdef1234567890abcdef12"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ai_chat)

        val promptEditText = findViewById<EditText>(R.id.promptEditText)
        val postButton = findViewById<Button>(R.id.postButton)

        postButton.setOnClickListener {
            Toast.makeText(this, "Please finish the objective", Toast.LENGTH_LONG).show()
        }
    }
}
