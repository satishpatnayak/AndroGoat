package owasp.sat.agoat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AccessControl1ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access_control1_view)
        val downloadInvoice=findViewById<Button>(R.id.downLoad)
        downloadInvoice.setOnClickListener{
            startService()
        }
    }

    fun startService()
    {
        val ServiceIntent=Intent(this, DownloadInvoiceService::class.java)
       // startService(Intent(applicationContext,DownloadInvoiceService::class.java))
        startService(ServiceIntent)
    }
}
