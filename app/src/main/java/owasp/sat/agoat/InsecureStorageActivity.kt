package owasp.sat.agoat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InsecureStorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage)
        val spButton = findViewById<Button>(R.id.SPButton)
        spButton.setOnClickListener{
            startActivity(Intent (this, InsecureStorageSharedPrefs::class.java))
        }

        val sp1Button = findViewById<Button>(R.id.SP1Button)
        sp1Button.setOnClickListener{
            startActivity(Intent (this, InsecureStorageSharedPrefs1Activity::class.java))
        }

        val sqlButton = findViewById<Button>(R.id.SQLButton)
        sqlButton.setOnClickListener{
            startActivity(Intent (this, InsecureStorageSQLiteActivity::class.java))
        }

        val tempButton = findViewById<Button>(R.id.tempButton)
        tempButton.setOnClickListener{
            startActivity(Intent (this, InsecureStorageTempActivity::class.java))
        }

        val sDcardButton = findViewById<Button>(R.id.SDcardButton)
        sDcardButton.setOnClickListener {
            startActivity(Intent(this, InsecureStorageSDCardActivity::class.java))
        }
    }
}
