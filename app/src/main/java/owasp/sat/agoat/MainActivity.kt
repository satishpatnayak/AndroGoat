package owasp.sat.agoat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootButton1.setOnClickListener{
            startActivity(Intent(this, RootDetectionActivity::class.java));
        }

        EmulatorButton.setOnClickListener{
            startActivity(Intent(this, EmulatorDetectionActivity::class.java))
        }

        InsecureStorage.setOnClickListener{
            startActivity(Intent(this, InsecureStorageActivity::class.java))
        }

        InputValidations.setOnClickListener{
            startActivity(Intent(this, InputValidationsActivity::class.java))
        }

        SideChannelLeakage.setOnClickListener{
            startActivity(Intent(this, SideChannelDataLeakageActivity::class.java))
        }

        AccessControl1.setOnClickListener{
            startActivity(Intent(this,AccessControlIssue1Activity::class.java));
        }

        Hardcode.setOnClickListener{
            startActivity(Intent(this,HardCodeActivity::class.java))
        }

        Traffic.setOnClickListener {
            startActivity(Intent(this, TrafficActivity::class.java))
        }

        BinaryPatching.setOnClickListener{
            startActivity(Intent(this,BinaryPatchingActivity::class.java))
        }

    }

}
