package owasp.sat.agoat

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.File

class EmulatorDetectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emulator_detection)

        val EmuButton = findViewById<Button>(R.id.EmulatorCheck);
        EmuButton.setOnClickListener {
            if (isEmulator()) {
                Toast.makeText(applicationContext, "This is Emulator", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(applicationContext, "This is not Emulator", Toast.LENGTH_LONG).show();
            }
        }
    }

    fun isEmulator(): Boolean {
            val builddtls = (Build.FINGERPRINT + Build.DEVICE + Build.MODEL + Build.BRAND + Build.PRODUCT + Build.MANUFACTURER + Build.HARDWARE).toLowerCase();
            return (builddtls.contains("generic")
               || builddtls.contains("unknown")
               || builddtls.contains("emulator")
               || builddtls.contains("sdk")
               || builddtls.contains("vbox")
               || builddtls.contains("genymotion")
               || builddtls.contains("x86")
               || builddtls.contains("goldfish")
               || builddtls.contains("test-keys"))
    }
}

