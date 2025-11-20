package owasp.sat.agoat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class InsecureStorageSharedPrefs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage_shared_prefs)

        val savebutton =findViewById<Button>(R.id.SPViewButton);
        val username =findViewById<EditText>(R.id.userName);
        val password= findViewById<EditText>(R.id.password);

        savebutton.setOnClickListener{
            val builder = androidx.appcompat.app.AlertDialog.Builder(this)
            builder.setTitle("Login")
            val sharedPreference = getSharedPreferences("users", Context.MODE_PRIVATE);
            var editor=sharedPreference.edit();
            editor.putString("username",username.text.toString());
            editor.putString("password", password.text.toString());
            if(editor.commit())
            {
                builder.setMessage("Username and Password are verified")
                Toast.makeText(applicationContext, "Username and Password are verified", Toast.LENGTH_LONG).show();
            }
            else
            {
                builder.setMessage("There is an issue while verifying the username and password")
                Toast.makeText(applicationContext, "There is an issue while verifying the username and password",Toast.LENGTH_LONG).show();
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

    }
}
