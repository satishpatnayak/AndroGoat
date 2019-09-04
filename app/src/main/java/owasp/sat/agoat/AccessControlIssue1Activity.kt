package owasp.sat.agoat

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_access_verify_pin.*
import org.jetbrains.anko.find
import java.security.MessageDigest

class AccessControlIssue1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(verifyIfPinSet()) {
            verifyPINView()
        }
        else
        {
            setContentView(R.layout.activity_access_control_issue1)
            val setPINButton=findViewById<Button>(R.id.setPIN)
            setPINButton.setOnClickListener {
                val pinValue=findViewById<EditText>(R.id.setpin)
                if(createPIN(pinValue.text.toString()))
                {
                    Toast.makeText(applicationContext, "PIN created. Please Login", Toast.LENGTH_LONG).show();
                    verifyPINView()
                }
                else
                {
                    Toast.makeText(applicationContext, "PIN not created", Toast.LENGTH_LONG).show();
                }

            }
        }
    }

    fun verifyIfPinSet():Boolean {
        val sharedPreferences = getSharedPreferences("pinDetails", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("pinSet",false)
    }
    fun createPIN(pinValue:String):Boolean{
        val sharedPreferences = getSharedPreferences("pinDetails", Context.MODE_PRIVATE)
        var editor1=sharedPreferences.edit()
        editor1.putBoolean("pinSet",true)
        editor1.putString("pin",hashPIN(pinValue))
        return editor1.commit()
    }

    fun isPinCorrect(pinValue: String):Boolean{
        val sharedPreferences = getSharedPreferences("pinDetails", Context.MODE_PRIVATE)
        return(sharedPreferences.getString("pin",null).equals(hashPIN(pinValue)))
    }

    fun verifyPINView()
    {
        setContentView(R.layout.activity_access_verify_pin)
        val verifyPINButton=findViewById<Button>(R.id.verifyPIN)
        verifyPINButton.setOnClickListener {
            val pinValue=findViewById<EditText>(R.id.pinValue)
            if(isPinCorrect(pinValue.text.toString()))
            {
                Toast.makeText(applicationContext, "PIN Verified", Toast.LENGTH_LONG).show();
                val myIntent=Intent(this, AccessControl1ViewActivity::class.java)
                startActivity(myIntent)
            }
            else
            {
                Toast.makeText(applicationContext, "Incorrect PIN entered", Toast.LENGTH_LONG).show();
            }
        }
    }

    fun hashPIN(pinValue: String):String{
        val md= MessageDigest.getInstance("MD5").digest(pinValue.toByteArray()).joinToString("") { "%02x".format(it) }
        return md

    }
}
