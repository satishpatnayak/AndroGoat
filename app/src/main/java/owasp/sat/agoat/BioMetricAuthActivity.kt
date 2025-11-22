package owasp.sat.agoat

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor

class BioMetricAuthActivity : AppCompatActivity() {

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio_metric_auth)

        val bioAuth = findViewById<Button>(R.id.bioauth)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Biometric login")

        executor = ContextCompat.getMainExecutor(this)

        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    builder.setMessage("Authentication error: $errString")
                    Toast.makeText(applicationContext, "Authentication error: $errString", Toast.LENGTH_SHORT).show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    builder.setMessage("Authentication succeeded!")
                    Toast.makeText(applicationContext, "Authentication succeeded! ", Toast.LENGTH_SHORT).show()
                    builder.setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    val dialog = builder.create()
                    dialog.show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    builder.setMessage("Authentication failed")
                    Toast.makeText(applicationContext, "Authentication failed", Toast.LENGTH_SHORT).show()
                    builder.setPositiveButton("OK") { dialog, _ ->dialog.dismiss()
                    }
                    val dialog = builder.create()
                    dialog.show()

                    // Auto-close logic: Dismiss the dialog after 3000ms (3 seconds)
                    android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                        if (dialog.isShowing) {
                            dialog.dismiss()
                        }
                    }, 3000)

                }


            })


        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Login")
            .setSubtitle("Log in using your biometric credential")
            .setNegativeButtonText("Cancel")
            .build()

        bioAuth.setOnClickListener {
            val biometricManager = BiometricManager.from(this)
            when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK)) {
                BiometricManager.BIOMETRIC_SUCCESS -> {
                    biometricPrompt.authenticate(promptInfo)
                }
                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                    Toast.makeText(this, "No biometric features available on this device.", Toast.LENGTH_LONG).show()
                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                    Toast.makeText(this, "Biometric features are currently unavailable.", Toast.LENGTH_LONG).show()
                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
                    Toast.makeText(this, "The user hasn't associated any biometric credentials.", Toast.LENGTH_LONG).show()
            }
        }
    }
}