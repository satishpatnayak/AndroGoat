package owasp.sat.agoat
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException
class TrafficActivity : AppCompatActivity() {
    var httpurl= "http://demo.testfire.net"
    var httpsurl= "https://owasp.org"
    var httpsurl1= "https://cve.org"
=======

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import okhttp3.*
import org.jetbrains.anko.doAsync
import java.io.IOException
import java.net.URL;
import org.json.JSONException
import org.json.JSONObject


class TrafficActivity : AppCompatActivity() {
    //var url = "https://reqres.in/api/users/2"
    var httpurl= "http://demo.testfire.net"
    var httpsurl= "https://owasp.org"//https://reqres.in/api/users?page=2"

>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic)
<<<<<<< HEAD

        // Allow network operations on the main thread for this example
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val HttpButton = findViewById<Button>(R.id.httpButton)
        val HttpsButton = findViewById<Button>(R.id.httpsButton)
        val PinningButton = findViewById<Button>(R.id.PinningButton)
        val PinningButton1 = findViewById<Button>(R.id.PinningButton1)

        //send HTTP request
=======
        val txtString = findViewById<TextView>(R.id.result)
        val HttpsButton = findViewById<Button>(R.id.httpsButton)
        val PinningButton=findViewById<Button>(R.id.PinningButton)

        //send HTTP request
        val HttpButton = findViewById<Button>(R.id.httpButton);
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
        HttpButton.setOnClickListener {
            run(httpurl)
        }

        //send HTTPS Request
<<<<<<< HEAD
        HttpsButton.setOnClickListener {
            run(httpsurl)
        }

        //Pinning call - Okhttp3

        PinningButton.setOnClickListener {
            doPinning()
        }

        //Pinning Call - Native
        PinningButton1.setOnClickListener {
            run(httpsurl1)
        }

    }//onCreate


     fun run(url: String) {
         try {
             val request = Request.Builder()
                 .url(url)
                 .build()
             Toast.makeText(this, "Request sent to "+url+" Please intercept using Proxy", Toast.LENGTH_LONG).show()

             client.newCall(request).enqueue(object : Callback {
                 override fun onFailure(call: Call, e: IOException) {}
                 override fun onResponse(call: Call, response: Response) = println(response.body?.string())
             })
         }
         catch (e:Exception)
         {
             e.printStackTrace()
         }
     }//run

    fun doPinning()
    {
        CoroutineScope(Dispatchers.IO).launch {
            val url="owasp.org"
            try {
                val pinner1 = CertificatePinner.Builder()
                    .add(url, "sha256/5gsjyidrmWjcLRClfCk+Dd6O0nx1CyFrVUW5wVkwEx0=")
                    .add(url, "sha256/kIdp6NNEd8wsugYyyIYFsi1ylMCED3hZbSR8ZFsa/A4=")
                    .add(url, "sha256/mEflZT5enoR1FuXLgYYGqnVEoZvmf9c2bVBpiOjYQ0c=")
                    .build()
                val client = OkHttpClient.Builder().certificatePinner(pinner1).build()
                val request = Request.Builder()
                    .url("https://"+url)
                    .build()
                //Toast.makeText(this@TrafficActivity, "Request Sent to https://"+url, Toast.LENGTH_LONG).show()
                val response = client.newCall(request).execute()
                Log.v("Response", "${response.body?.string()}")
=======
        HttpsButton.setOnClickListener{
            run(httpsurl)
        }

        //Pinning call

        PinningButton.setOnClickListener{
            //val httpsurl1=URL(httpsurl)
           //MyConnection().execute(httpsurl1)
            doPinning()
        }
    }//onCreate

    /*inner class MyConnection : AsyncTask<URL, Void, String>()
    {
        val url:String= "https://owasp.org"
        var result:String=""
        override fun doInBackground(vararg params: URL?):String {
            try{
                val pinner1=CertificatePinner.Builder()
                        .add(url, "sha256/gdU/UHClHJBFbIdeKuyHm/Lq/aQvMLyuTtcvTEE/1JQ=")
                        .add(url, "sha256/YLh1dUR9y6Kja30RrAn7JKnbQG/uEtLMkBgFF2Fuihg=")
                        .add(url, "sha256/Vjs8r4z+80wjNcr1YKepWQboSIRi63WsWXhIMN+eWys=")
                        .build()
                val client=OkHttpClient.Builder().certificatePinner(pinner1).build()
                val request=Request.Builder()
                        .url(url)
                        .build()
                val response=client.newCall(request).execute()
                result=response.body().toString()
                Log.v("Response", result)
            }
            catch (e:Exception)
            {
                e.printStackTrace()
            }
           return result
        }
    }*/


    fun run(url: String) {
        try {
            val request = Request.Builder()
                    .url(url)
                    .build()
            Toast.makeText(this, "Request sent to "+url+" Please intercept using Proxy", Toast.LENGTH_LONG).show()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {}
                override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
            })
        }
        catch (e:Exception)
        {
            e.printStackTrace()
        }
    }//run

  fun doPinning()
    {
        doAsync {
            val url="owasp.org"
            try {
                val pinner1 = CertificatePinner.Builder()
                        .add(url, "sha256/gdU/UHClHJBFbIdeKuyHm/Lq/aQvMLyuTtcvTEE/1JQ=")
                        .add(url, "sha256/YLh1dUR9y6Kja30RrAn7JKnbQG/uEtLMkBgFF2Fuihg=")
                        .add(url, "sha256/Vjs8r4z+80wjNcr1YKepWQboSIRi63WsWXhIMN+eWys=")
                        .build()
                val client = OkHttpClient.Builder().certificatePinner(pinner1).build()
                val request = Request.Builder()
                        .url("https://"+url)
                        .build()
                //Toast.makeText(this@TrafficActivity, "Request Sent to https://"+url, Toast.LENGTH_LONG).show()
                val response = client.newCall(request).execute()
                Log.v("Response", response.body()?.string())
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
            } catch (e: Exception) {
                //Toast.makeText(this@TrafficActivity, "Pinning Verification Failed", Toast.LENGTH_LONG).show()
                e.printStackTrace()
            }
        }

    }//doPinning*/
<<<<<<< HEAD
}
=======




}
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
