package owasp.sat.agoat

import android.app.DownloadManager
<<<<<<< HEAD
=======
import android.app.IntentService
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.IBinder
import android.util.Log
import android.widget.Toast
<<<<<<< HEAD

class DownloadInvoiceService : Service() {

    override fun onCreate() {
        Log.i("DOWNLOAD", "Service onCreate")
        Toast.makeText(applicationContext, "Service Created", Toast.LENGTH_LONG).show()
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.i("DOWNLOAD", "Service onBind")
        return null
=======
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.stopService
import java.lang.Thread.sleep

class DownloadInvoiceService : Service() {

    override fun onCreate(){
        Log.i("DOWNLOAD", "Service onCreate")
        Toast.makeText(applicationContext, "Service Created", Toast.LENGTH_LONG).show();
        //stopSelf()
    }

    override fun onBind(intent: Intent): IBinder? {
        //TODO("Return the communication channel to the service.")
        //throw UnsupportedOperationException("Not yet implemented")
        Log.i("DOWNLOAD", "Service onBind")
        return null

>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("DOWNLOAD", "Invoice is being downloaded")
        downloadFile()
<<<<<<< HEAD
        Toast.makeText(applicationContext, "Invoice is being downloaded", Toast.LENGTH_LONG).show()
        stopSelf()
        return START_NOT_STICKY
    }

=======
        Toast.makeText(applicationContext, "Invoice is being downloaded", Toast.LENGTH_LONG).show();
        return Service.START_STICKY
        sleep(10000)
        stopService(intent)
    }
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
    override fun onDestroy() {
        Log.i("DOWNLOAD", "Service onDestroy")
    }

<<<<<<< HEAD
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
=======
  fun downloadFile(){
        doAsync{
            val url1="https://github.com/satishpatnayak/MyTest/blob/master/AndroGoatInvoice.txt"
        val url:Uri=Uri.parse(url1)
        val request=DownloadManager.Request(url)
        val fileName:String=url.lastPathSegment
        request.apply{
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        request.setTitle(fileName)
        request.setDescription("The File is downloading...")
        request.allowScanningByMediaScanner()
//            request.setMimeType("images/gif")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${System.currentTimeMillis()}")
        val manager=getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)
        }
        }
    }



    }

>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
