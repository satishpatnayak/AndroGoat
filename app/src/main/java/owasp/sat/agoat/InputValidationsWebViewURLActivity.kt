package owasp.sat.agoat

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.find
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class InputValidationsWebViewURLActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_validations_web_view_url)
<<<<<<< HEAD
        val loadButton = findViewById<Button>(R.id.load)
        val webView = findViewById<WebView>(R.id.webview1)
        val urlEditText = findViewById<EditText>(R.id.url)

        loadButton.setOnClickListener {
            val webViewSettings=webView.settings;
            webViewSettings.javaScriptEnabled=true;
            webViewSettings.allowFileAccess=true;
            webViewSettings.allowContentAccess = true
            webViewSettings.allowFileAccessFromFileURLs = true
            webViewSettings.allowUniversalAccessFromFileURLs = true
            val url = urlEditText.text.toString()
            webView.loadUrl(url)
=======
        val load=findViewById<Button>(R.id.load)
        val webview11:WebView=findViewById(R.id.webview1);
        val url=findViewById<TextView>(R.id.url)
        load.setOnClickListener{
           // webview1.webChromeClient= WebChromeClient()
            val webSettings1=webview11.settings;
            webSettings1.javaScriptEnabled=true;
            val url:String=url.text.toString()
            webview11.loadUrl(url)
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
        }
    }
}
