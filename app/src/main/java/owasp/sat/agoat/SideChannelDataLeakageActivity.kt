package owasp.sat.agoat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SideChannelDataLeakageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side_channel_data_leakage)
        val logging = findViewById<Button>(R.id.Logging)
        logging.setOnClickListener{
            startActivity(Intent(this, InsecureLoggingActivity::class.java))
        }
        val clipboard = findViewById<Button>(R.id.clipboard)
        clipboard.setOnClickListener{
            startActivity(Intent(this, ClipboardActivity::class.java))
        }
        val dict = findViewById<Button>(R.id.Dict)
        dict.setOnClickListener{
            startActivity(Intent(this, KeyboardCacheActivity::class.java))
        }
    }
}
