package owasp.sat.agoat

import android.app.DownloadManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class DownloadInvoiceService : Service() {

    override fun onCreate() {
        Log.i("DOWNLOAD", "Service onCreate")
        Toast.makeText(applicationContext, "Service Created", Toast.LENGTH_LONG).show()
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.i("DOWNLOAD", "Service onBind")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("DOWNLOAD", "Invoice is being downloaded")
        downloadFile()
        Toast.makeText(applicationContext, "Invoice is being downloaded", Toast.LENGTH_LONG).show()
        stopSelf()
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        Log.i("DOWNLOAD", "Service onDestroy")
    }

    private fun downloadFile() {
        Thread {
            val url1 = "https://raw.githubusercontent.com/satishpatnayak/MyTest/master/AndroGoatInvoice.txt"
            val url: Uri = Uri.parse(url1)
            val request = DownloadManager.Request(url)
            val fileName: String = url.lastPathSegment ?: "AndroGoatInvoice.txt"
            request.apply {
                setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                setTitle(fileName)
                setDescription("The File is downloading...")
                allowScanningByMediaScanner()
                setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "${System.currentTimeMillis()}_invoice.txt")
                val manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                manager.enqueue(request)
            }
        }.start()
    }
}
