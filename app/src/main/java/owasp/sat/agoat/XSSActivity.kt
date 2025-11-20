package owasp.sat.agoat

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_xss.*
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class XSSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_xss)
<<<<<<< HEAD
        val webView = findViewById<WebView>(R.id.webview)
        webView.webChromeClient = WebChromeClient()
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        val data = "<html>\n" +
=======
        val webview1=findViewById<WebView>(R.id.webview);
        webview1.webChromeClient=WebChromeClient()
        val webSettings1=webview1.settings;
        webSettings1.javaScriptEnabled=true;
        val data: String = "<html>\n" +
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
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
<<<<<<< HEAD
                "<br/><br/><input type=\"button\" value=\"Display\" onclick=\"displayContent()\" style=\"background-color:black;color: white; border: 2px solid #000000\"/>\n" +
                "</body>\n" +
                "\n" +
                "</html>"
        //webView.loadData(data, "text/html", "UTF-8")
        webView.loadDataWithBaseURL(null, data, "text/html", "UTF-8", null)
=======
                "</br></br><input type=\"button\" value=\"Display\" onclick=\"displayContent()\" style=\"background-color:black;color: white;\n" +
                "  border: 2px solid #000000\"/>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        webview1.loadData(data, "text/html", "UTF-8");



>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
    }
}
