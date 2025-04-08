package owasp.sat.agoat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import owasp.sat.agoat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rootButton1.setOnClickListener{
            startActivity(Intent(this, RootDetectionActivity::class.java));
        }

        binding.EmulatorButton.setOnClickListener{
            startActivity(Intent(this, EmulatorDetectionActivity::class.java))
        }

        binding.InsecureStorage.setOnClickListener{
            startActivity(Intent(this, InsecureStorageActivity::class.java))
        }

        binding.InputValidations.setOnClickListener{
            startActivity(Intent(this, InputValidationsActivity::class.java))
        }

        binding.SideChannelLeakage.setOnClickListener{
            startActivity(Intent(this, SideChannelDataLeakageActivity::class.java))
        }

        binding.AccessControl1.setOnClickListener{
            startActivity(Intent(this,AccessControlIssue1Activity::class.java));
        }

        binding.Hardcode.setOnClickListener{
            startActivity(Intent(this,HardCodeActivity::class.java))
        }

        binding.Traffic.setOnClickListener {
            startActivity(Intent(this, TrafficActivity::class.java))
        }

        binding.BinaryPatching.setOnClickListener{
            startActivity(Intent(this,BinaryPatchingActivity::class.java))
        }

    }

}
