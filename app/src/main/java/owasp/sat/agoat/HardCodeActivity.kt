package owasp.sat.agoat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class HardCodeActivity : AppCompatActivity() {

    private val promoCode: String = "NEW2019"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard_code)
        val verifyButton = findViewById<Button>(R.id.hardcode1)
        val priceValue = findViewById<TextView>(R.id.price)
        val promoCodeValue = findViewById<EditText>(R.id.promocode)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Alert!")
        verifyButton.setOnClickListener {
            if (promoCodeValue.text.toString().equals(promoCode, ignoreCase = true)) {
                priceValue.text = "0"
                builder.setMessage("Congratulations! You got this product for free")
                Toast.makeText(this, "Congratulations! You got this product for free", Toast.LENGTH_LONG).show()
            } else {
                builder.setMessage("Sorry! Incorrect Promocode was entered")
                Toast.makeText(this, "Sorry! Incorrect Promocode was entered", Toast.LENGTH_LONG).show()
                priceValue.text = "2000"
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

    }
}
