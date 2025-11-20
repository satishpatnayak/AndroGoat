package owasp.sat.agoat

<<<<<<< HEAD
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
=======
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings.Global.getString
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
import android.widget.Toast

class ShowDataReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
<<<<<<< HEAD
        Toast.makeText(context, "Username is CrazyUser, Password is CrazyPassword and Key is 123myKey456", Toast.LENGTH_LONG).show()
=======
        Toast.makeText(context, "Username is CrazyUser, Password is CrazyPassword and Key is 123myKey456"  , Toast.LENGTH_LONG).show();

>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
    }
}
