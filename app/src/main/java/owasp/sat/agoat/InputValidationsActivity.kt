package owasp.sat.agoat

import android.content.Intent
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_input_validations.*
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class InputValidationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_validations)

<<<<<<< HEAD
        val xssBtn = findViewById<Button>(R.id.xssBtn)
        xssBtn.setOnClickListener {
            startActivity(Intent(this, XSSActivity::class.java))
        }

        val sqliButton = findViewById<Button>(R.id.sqliButton)
        sqliButton.setOnClickListener {
            startActivity(Intent(this, SQLinjectionActivity::class.java))
        }

        val wbUrl = findViewById<Button>(R.id.wbUrl)
        wbUrl.setOnClickListener {
            startActivity(Intent(this, InputValidationsWebViewURLActivity::class.java))
        }

        val oscmdi = findViewById<Button>(R.id.oscmdi)
        oscmdi.setOnClickListener {
            startActivity(Intent(this, InputValidationsOSCMDInjectionMain2Activity::class.java))
        }
    }
=======
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


>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
}
