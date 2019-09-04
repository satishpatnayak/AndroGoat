package owasp.sat.agoat

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_clipboard.*
import java.util.*


class ClipboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clipboard)
        val ccValue=findViewById<EditText>(R.id.cc)

        verifyCC.setOnClickListener{
        val ccValue1:String=ccValue.text.toString().trim()
            if(ccValue1 != null && !ccValue1.isEmpty()) {
                val otp = (1000..9999).shuffled().first()
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("CC Card", otp.toString())
                clipboard.primaryClip = clip
                Toast.makeText(this, "OTP Generated and Copied: " + otp, Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this, "Credit Card shouldn't be blank", Toast.LENGTH_LONG).show()
            }
        }
    }
}
