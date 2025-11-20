package owasp.sat.agoat

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class EmulatorDetectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emulator_detection)

        val emuButton = findViewById<Button>(R.id.EmulatorCheck)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Emulator Detection")
        emuButton.setOnClickListener {
            if (isEmulator()) {
                builder.setMessage("This device is an Emulator")
                Toast.makeText(applicationContext, "This device is an Emulator", Toast.LENGTH_LONG).show()
            } else {
                builder.setMessage("This device is not an Emulator")
                Toast.makeText(applicationContext, "This device is not an Emulator", Toast.LENGTH_LONG).show()
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }
    }

    private fun isEmulator(): Boolean {
        val buildDetails = (Build.FINGERPRINT + Build.DEVICE + Build.MODEL + Build.BRAND + Build.PRODUCT + Build.MANUFACTURER + Build.HARDWARE).toLowerCase()
        return (buildDetails.contains("generic")
                || buildDetails.contains("unknown")
                || buildDetails.contains("emulator")
                || buildDetails.contains("sdk")
                || buildDetails.contains("vbox")
                || buildDetails.contains("genymotion")
                || buildDetails.contains("x86")
                || buildDetails.contains("goldfish")
                || buildDetails.contains("test-keys"))
    }
}
