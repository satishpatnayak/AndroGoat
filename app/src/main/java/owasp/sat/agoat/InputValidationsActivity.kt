package owasp.sat.agoat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_input_validations.*

class InputValidationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_validations)

        xssBtn.setOnClickListener{
            startActivity(Intent (this, XSSActivity::class.java));
        }

        sqliButton.setOnClickListener{
            startActivity(Intent (this, SQLinjectionActivity::class.java));
        }

        wbUrl.setOnClickListener{
            startActivity(Intent (this, InputValidationsWebViewURLActivity::class.java))
        }

        oscmdi.setOnClickListener{
            startActivity(Intent (this, InputValidationsOSCMDInjectionMain2Activity::class.java))
        }

    }


}
