package owasp.sat.agoat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootButton1 = findViewById<Button>(R.id.rootButton1)
        rootButton1.setOnClickListener {
            startActivity(Intent(this, RootDetectionActivity::class.java))
        }

        val emulatorButton = findViewById<Button>(R.id.EmulatorButton)
        emulatorButton.setOnClickListener {
            startActivity(Intent(this, EmulatorDetectionActivity::class.java))
        }

        val insecureStorage = findViewById<Button>(R.id.InsecureStorage)
        insecureStorage.setOnClickListener {
            startActivity(Intent(this, InsecureStorageActivity::class.java))
        }

        val inputValidations = findViewById<Button>(R.id.InputValidations)
        inputValidations.setOnClickListener {
            startActivity(Intent(this, InputValidationsActivity::class.java))
        }

        val sideChannelLeakage = findViewById<Button>(R.id.SideChannelLeakage)
        sideChannelLeakage.setOnClickListener {
            startActivity(Intent(this, SideChannelDataLeakageActivity::class.java))
        }

        val accessControl1 = findViewById<Button>(R.id.AccessControl1)
        accessControl1.setOnClickListener {
            startActivity(Intent(this, AccessControlIssue1Activity::class.java))
        }

        val hardcode = findViewById<Button>(R.id.Hardcode)
        hardcode.setOnClickListener {
            startActivity(Intent(this, HardcodeViewActivity::class.java))
        }

        val traffic = findViewById<Button>(R.id.Traffic)
        traffic.setOnClickListener {
            startActivity(Intent(this, TrafficActivity::class.java))
        }

        val binaryPatching = findViewById<Button>(R.id.BinaryPatching)
        binaryPatching.setOnClickListener {
            startActivity(Intent(this, BinaryPatchingActivity::class.java))
        }

        val biopath = findViewById<Button>(R.id.bioauth1)
        biopath.setOnClickListener {
            startActivity(Intent(this, BioMetricAuthActivity::class.java))
        }
    }
}
