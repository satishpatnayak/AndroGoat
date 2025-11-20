package owasp.sat.agoat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView

class XSSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_xss)
        val webView = findViewById<WebView>(R.id.webview)
        webView.webChromeClient = WebChromeClient()
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        val data = "<html>\n" +
                "<body>\n" +
                "<script>\n" +
                "function displayContent()\n" +
                "{\n" +
                "var a=document.getElementById(\"name\");\n" +
                "document.write(a.value);\n" +
                "\n" +
                "}\n" +
                "</script>\n" +
                "Name: <input type=\"text\" id=\"name\"/>\n" +
                "<br/><br/><input type=\"button\" value=\"Display\" onclick=\"displayContent()\" style=\"background-color:black;color: white; border: 2px solid #000000\"/>\n" +
                "</body>\n" +
                "\n" +
                "</html>"
        //webView.loadData(data, "text/html", "UTF-8")
        webView.loadDataWithBaseURL(null, data, "text/html", "UTF-8", null)
    }
}
