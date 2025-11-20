package owasp.sat.agoat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AccessControl1ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access_control1_view)
        val downloadInvoice = findViewById<Button>(R.id.downLoad)
        downloadInvoice.setOnClickListener {
            val serviceIntent = Intent(this, DownloadInvoiceService::class.java)
            startService(serviceIntent)
        }
    }
}
