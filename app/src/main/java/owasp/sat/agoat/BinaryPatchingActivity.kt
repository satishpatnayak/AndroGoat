package owasp.sat.agoat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class BinaryPatchingActivity : AppCompatActivity() {
    private val isAdmin:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary_patching)
        val isAdminText = findViewById<TextView>(R.id.isAdminText)
        val adminButton = findViewById<Button>(R.id.adminButton)

        if(isAdmin) {
            isAdminText.text = "You are Admin Now"
            adminButton.setBackgroundColor(android.graphics.Color.parseColor("#000000"))
            adminButton.setTextColor(android.graphics.Color.parseColor("#FFFFFF"))
            adminButton.isEnabled = true
        }
        adminButton.setOnClickListener{
            Toast.makeText(this,"You clicked on Administration button", Toast.LENGTH_LONG).show()
        }
    }
}
