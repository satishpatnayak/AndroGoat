package owasp.sat.agoat

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback

class QRCodeXSSActivity : AppCompatActivity() {

    private lateinit var codeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode_xssactivity)

        // 1. Check Camera Permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 101)
        }

        val scannerView = findViewById<CodeScannerView>(R.id.scanner_view)
        val webView = findViewById<WebView>(R.id.webviewxss)

        // 2. Enable JavaScript (Required for XSS to work)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient() // Handle alert() popups

        // 3. Initialize Scanner
        codeScanner = CodeScanner(this, scannerView)

        // 4. The Vulnerable Logic
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                val scannedText = it.text

                // VULNERABILITY: Taking input directly from QR and putting it into HTML
                val htmlData = """
                    <html>
                    <body>
                        <h2>Scanned Product Details</h2>
                        <h3>Product Found!</h3>
                        <p>Product ID: <b>$scannedText</b></p>
                        <p>Status: Available</p>
                    </body>
                    </html>
                """.trimIndent()

                // Load the data directly
                webView.loadData(htmlData, "text/html", "UTF-8")

                Toast.makeText(this, "Scan Complete", Toast.LENGTH_SHORT).show()
            }
        }

        // Start scanning when clicked
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        if (::codeScanner.isInitialized) {
            codeScanner.startPreview()
        }
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}