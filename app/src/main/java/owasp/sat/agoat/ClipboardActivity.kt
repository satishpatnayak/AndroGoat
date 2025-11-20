package owasp.sat.agoat

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ClipboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clipboard)
        val ccValue = findViewById<EditText>(R.id.cc)
        val verifyCC = findViewById<Button>(R.id.verifyCC)

        verifyCC.setOnClickListener {
            val ccValue1: String = ccValue.text.toString().trim()
            if (ccValue1.isNotEmpty()) {
                val otp = (1000..9999).shuffled().first()
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("CC Card", otp.toString())
                clipboard.setPrimaryClip(clip)
                Toast.makeText(this, "OTP Generated and Copied: $otp", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Credit Card shouldn't be blank", Toast.LENGTH_LONG).show()
            }
        }
    }
}
