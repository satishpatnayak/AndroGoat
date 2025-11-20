package owasp.sat.agoat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HardcodeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hardcode_view)
        val buyProductButton = findViewById<Button>(R.id.buyProductButton)
        val aiChatButton = findViewById<Button>(R.id.aiChatButton)
        val cloudServiceButton = findViewById<Button>(R.id.CloudButton)


        buyProductButton.setOnClickListener {
            val intent = Intent(this, HardCodeActivity::class.java)
            startActivity(intent)
        }

        aiChatButton.setOnClickListener {
            val intent = Intent(this, AIChatActivity::class.java)
            startActivity(intent)
        }

        cloudServiceButton.setOnClickListener {
            val intent = Intent(this, CloudServicesActivity::class.java)
            startActivity(intent)
        }
    }
}