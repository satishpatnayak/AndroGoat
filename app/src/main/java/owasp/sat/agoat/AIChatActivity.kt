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
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Login")
        postButton.setOnClickListener {
            builder.setMessage("Connected to OpenAI using key "+ openAIApiKey+". Please finish the objective")
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
            Toast.makeText(this, "Connected to OpenAI using key"+ openAIApiKey+". Please finish the objective", Toast.LENGTH_LONG).show()
        }
    }
}
