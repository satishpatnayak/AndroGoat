package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class HardCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard_code)
        val VerifyButton=findViewById<Button>(R.id.hardcode1);
        val priceValue=findViewById<TextView>(R.id.price);
        val promoCodeValue=findViewById<EditText>(R.id.promocode);
        var promoCode:String= "NEW2019"

        VerifyButton.setOnClickListener{
            if(promoCodeValue.text.toString().equals(promoCode))
            {
                priceValue.text="0";
                Toast.makeText(applicationContext, "Congratulations! You got this product for free" , Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(applicationContext, "Sorry! Incorrect Promocode was entered", Toast.LENGTH_LONG).show();
                priceValue.text="2000";
            }
        }

    }
}
