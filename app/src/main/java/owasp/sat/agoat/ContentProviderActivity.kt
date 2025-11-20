package owasp.sat.agoat

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_content_provider.*
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class ContentProviderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
<<<<<<< HEAD
        val username = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val cpViewButton = findViewById<Button>(R.id.CPViewButton)

        cpViewButton.setOnClickListener{
            // In a real app, you would do something with the username and password
        }
    }
=======
        val username=findViewById<EditText>(R.id.userName)
        val password=findViewById<EditText>(R.id.password)

        CPViewButton.setOnClickListener{

        }
    }


>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
}
