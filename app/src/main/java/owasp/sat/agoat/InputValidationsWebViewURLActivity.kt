package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.find

class InputValidationsWebViewURLActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_validations_web_view_url)
        val load=findViewById<Button>(R.id.load)
        val webview11:WebView=findViewById(R.id.webview1);
        val url=findViewById<TextView>(R.id.url)
        load.setOnClickListener{
           // webview1.webChromeClient= WebChromeClient()
            val webSettings1=webview11.settings;
            webSettings1.javaScriptEnabled=true;
            val url:String=url.text.toString()
            webview11.loadUrl(url)
        }
    }
}
