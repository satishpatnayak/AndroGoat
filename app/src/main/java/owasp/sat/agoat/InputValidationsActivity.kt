package owasp.sat.agoat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InputValidationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_validations)

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
}
