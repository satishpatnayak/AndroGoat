package owasp.sat.agoat

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InsecureStorageSharedPrefs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage_shared_prefs)

        val savebutton =findViewById<Button>(R.id.SPViewButton);
        val username =findViewById<EditText>(R.id.userName);
        val password= findViewById<EditText>(R.id.password);

        savebutton.setOnClickListener{
            val sharedPreference = getSharedPreferences("users", Context.MODE_PRIVATE);
            var editor=sharedPreference.edit();
            editor.putString("username",username.text.toString());
            editor.putString("password", password.text.toString());
            if(editor.commit())
            {
                Toast.makeText(applicationContext, "Data saved", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(applicationContext, "Data not saved",Toast.LENGTH_LONG).show();
            }


        }

    }
}
