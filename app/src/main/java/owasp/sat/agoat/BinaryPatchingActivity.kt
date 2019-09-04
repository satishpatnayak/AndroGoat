package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_binary_patching.*
import java.security.MessageDigest

class BinaryPatchingActivity : AppCompatActivity() {
    val isAdmin:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary_patching)

        if(isAdmin==true)
        {
            isAdminText.text="You are Admin Now"
            adminButton.isEnabled=true
        }
        adminButton.setOnClickListener{
            Toast.makeText(this,"You clicked on Administartion button", Toast.LENGTH_LONG).show()
        }
    }
}
