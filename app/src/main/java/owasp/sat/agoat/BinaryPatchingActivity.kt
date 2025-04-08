package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import owasp.sat.agoat.databinding.ActivityBinaryPatchingBinding

class BinaryPatchingActivity : AppCompatActivity() {
    val isAdmin:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBinaryPatchingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(isAdmin==true)
        {
            binding.isAdminText.text="You are Admin Now"
            binding.adminButton.isEnabled=true
        }
        binding.adminButton.setOnClickListener{
            Toast.makeText(this,"You clicked on Administartion button", Toast.LENGTH_LONG).show()
        }
    }
}
