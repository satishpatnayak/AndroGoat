package owasp.sat.agoat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_insecure_storage.*

class InsecureStorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage)
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
            startActivity(Intent(this, InsecureStorageSDCardActivity::class.java))
        }
    }
}
