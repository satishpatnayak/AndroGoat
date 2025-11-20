package owasp.sat.agoat

import android.content.Intent
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_insecure_storage.*
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class InsecureStorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage)
<<<<<<< HEAD
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
=======
        SPButton.setOnClickListener{
            startActivity(Intent (this, InsecureStorageSharedPrefs::class.java));
        }

        SP1Button.setOnClickListener{
            startActivity(Intent (this, InsecureStorageSharedPrefs1Activity::class.java));
        }

        SQLButton.setOnClickListener{
            startActivity(Intent (this, InsecureStorageSQLiteActivity::class.java))
        }

        tempButton.setOnClickListener{
            startActivity(Intent (this, InsecureStorageTempActivity::class.java));
        }

        SDcardButton.setOnClickListener {
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
            startActivity(Intent(this, InsecureStorageSDCardActivity::class.java))
        }
    }
}
