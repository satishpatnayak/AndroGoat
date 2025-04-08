package owasp.sat.agoat

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import owasp.sat.agoat.databinding.ActivityInputValidationsBinding

class InputValidationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInputValidationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.xssBtn.setOnClickListener{
            startActivity(Intent (this, XSSActivity::class.java));
        }

        binding.sqliButton.setOnClickListener{
            startActivity(Intent (this, SQLinjectionActivity::class.java));
        }

        binding.wbUrl.setOnClickListener{
            startActivity(Intent (this, InputValidationsWebViewURLActivity::class.java))
        }

        binding.oscmdi.setOnClickListener{
            startActivity(Intent (this, InputValidationsOSCMDInjectionMain2Activity::class.java))
        }

    }


}
