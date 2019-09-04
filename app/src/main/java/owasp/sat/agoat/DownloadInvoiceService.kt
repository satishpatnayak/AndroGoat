package owasp.sat.agoat

import android.app.DownloadManager
import android.app.IntentService
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.IBinder
import android.util.Log
import android.widget.Toast
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

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("DOWNLOAD", "Invoice is being downloaded")
        downloadFile()
        Toast.makeText(applicationContext, "Invoice is being downloaded", Toast.LENGTH_LONG).show();
        return Service.START_STICKY
        sleep(10000)
        stopService(intent)
    }
    override fun onDestroy() {
        Log.i("DOWNLOAD", "Service onDestroy")
    }

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

