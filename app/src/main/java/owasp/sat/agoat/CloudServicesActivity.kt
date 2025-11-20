package owasp.sat.agoat

import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CloudServicesActivity : AppCompatActivity() {
    private val aws_access_key_id = "AKIAX56QKKOLPQ7G7ABC"
    private val aws_secret_access_key = "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"
    val output = "json"
    val region = "ap-south-2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cloud_services)
        val cloudServices = findViewById<Button>(R.id.viewCloudServices)

        cloudServices.setOnClickListener {
            Toast.makeText(applicationContext, "Connected to AWS account using Access key " + aws_access_key_id + "and secret key " + aws_secret_access_key , Toast.LENGTH_LONG).show()
            Log.d("[Info]", "Connected to AWS account using Access key " + aws_access_key_id + "and secret key " + aws_secret_access_key)
            setContentView(R.layout.activity_cloud_services_view)
        }
    }
}