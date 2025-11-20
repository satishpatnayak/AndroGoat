package owasp.sat.agoat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText

class InputValidationsWebViewURLActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_validations_web_view_url)
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
        }
    }
}
