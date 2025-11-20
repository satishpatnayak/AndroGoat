package owasp.sat.agoat

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ShowDataReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Username is CrazyUser, Password is CrazyPassword and Key is 123myKey456", Toast.LENGTH_LONG).show()
    }
}
