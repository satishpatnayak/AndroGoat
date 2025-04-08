package owasp.sat.agoat

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import owasp.sat.agoat.databinding.ActivityInsecureStorageBinding

class InsecureStorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInsecureStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.SPButton.setOnClickListener{
            startActivity(Intent (this, InsecureStorageSharedPrefs::class.java));
        }

        binding.SP1Button.setOnClickListener{
            startActivity(Intent (this, InsecureStorageSharedPrefs1Activity::class.java));
        }

        binding.SQLButton.setOnClickListener{
            startActivity(Intent (this, InsecureStorageSQLiteActivity::class.java))
        }

        binding.tempButton.setOnClickListener{
            startActivity(Intent (this, InsecureStorageTempActivity::class.java));
        }

        binding.SDcardButton.setOnClickListener {
            startActivity(Intent(this, InsecureStorageSDCardActivity::class.java))
        }
    }
}
