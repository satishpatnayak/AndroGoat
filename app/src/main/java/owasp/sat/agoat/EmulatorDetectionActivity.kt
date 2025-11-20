package owasp.sat.agoat

import android.os.Build
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.File
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class EmulatorDetectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emulator_detection)

<<<<<<< HEAD
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
=======
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

>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
