package owasp.sat.agoat

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class BinaryPatchingActivity : AppCompatActivity() {
    private val isAdmin:Boolean = false
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_binary_patching.*
import java.security.MessageDigest

class BinaryPatchingActivity : AppCompatActivity() {
    val isAdmin:Boolean=false
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary_patching)
<<<<<<< HEAD
        val isAdminText = findViewById<TextView>(R.id.isAdminText)
        val adminButton = findViewById<Button>(R.id.adminButton)

        if(isAdmin) {
            isAdminText.text = "You are Admin Now"
            adminButton.setBackgroundColor(android.graphics.Color.parseColor("#000000"))
            adminButton.setTextColor(android.graphics.Color.parseColor("#FFFFFF"))
            adminButton.isEnabled = true
        }
        adminButton.setOnClickListener{
            Toast.makeText(this,"You clicked on Administration button", Toast.LENGTH_LONG).show()
=======

        if(isAdmin==true)
        {
            isAdminText.text="You are Admin Now"
            adminButton.isEnabled=true
        }
        adminButton.setOnClickListener{
            Toast.makeText(this,"You clicked on Administartion button", Toast.LENGTH_LONG).show()
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
        }
    }
}
