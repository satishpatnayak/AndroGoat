package owasp.sat.agoat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_side_channel_data_leakage.*

class SideChannelDataLeakageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side_channel_data_leakage)

        Logging.setOnClickListener{
            startActivity(Intent(this, InsecureLoggingActivity::class.java));
        }

        clipboard.setOnClickListener{
            startActivity(Intent(this, ClipboardActivity::class.java))
        }

        Dict.setOnClickListener{
            startActivity(Intent(this, KeyboardCacheActivity::class.java))
        }
    }
}
