package owasp.sat.agoat

import android.content.Intent
<<<<<<< HEAD
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class AccessControl1ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access_control1_view)
<<<<<<< HEAD
        val downloadInvoice = findViewById<Button>(R.id.downLoad)
        downloadInvoice.setOnClickListener {
            val serviceIntent = Intent(this, DownloadInvoiceService::class.java)
            startService(serviceIntent)
        }
    }
=======
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
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
}
