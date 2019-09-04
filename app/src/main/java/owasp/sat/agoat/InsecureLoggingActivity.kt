package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insecure_logging.*

class InsecureLoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_logging)
        val username=findViewById<EditText>(R.id.userName);
        val password=findViewById<EditText>(R.id.password);
        Logging1.setOnClickListener{
            Log.e("Error:","Error occured when processing Username "+ username.text+"  and Password " +password.text);
            System.out.println("Error: Error occured when processing Username "+ username.text+"  and Password " +password.text);
            Toast.makeText(applicationContext, "Error Occured", Toast.LENGTH_LONG).show();
        }
    }
}
