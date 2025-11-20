package owasp.sat.agoat

import android.content.Intent
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_side_channel_data_leakage.*
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class SideChannelDataLeakageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side_channel_data_leakage)
<<<<<<< HEAD
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
=======

        Logging.setOnClickListener{
            startActivity(Intent(this, InsecureLoggingActivity::class.java));
        }

        clipboard.setOnClickListener{
            startActivity(Intent(this, ClipboardActivity::class.java))
        }

        Dict.setOnClickListener{
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
            startActivity(Intent(this, KeyboardCacheActivity::class.java))
        }
    }
}
