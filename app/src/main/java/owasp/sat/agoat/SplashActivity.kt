package owasp.sat.agoat

import android.content.Intent
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
=======
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import org.jetbrains.anko.startActivity
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
<<<<<<< HEAD
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 5000)
=======
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },5000)
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
    }
}
