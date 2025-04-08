package owasp.sat.agoat

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import owasp.sat.agoat.databinding.ActivitySideChannelDataLeakageBinding

class SideChannelDataLeakageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySideChannelDataLeakageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Logging.setOnClickListener{
            startActivity(Intent(this, InsecureLoggingActivity::class.java));
        }

        binding.clipboard.setOnClickListener{
            startActivity(Intent(this, ClipboardActivity::class.java))
        }

        binding.Dict.setOnClickListener{
            startActivity(Intent(this, KeyboardCacheActivity::class.java))
        }
    }
}
