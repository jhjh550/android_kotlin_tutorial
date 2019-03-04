package example.com.kotlin_android_api_tutorial.T16_BR

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("MyReceiver", "hello")
        Toast.makeText(context, "receiver activiated", Toast.LENGTH_SHORT).show()
        if(intent.action == Intent.ACTION_BATTERY_CHANGED){
            val level = intent.getIntExtra("level", 0)
            Toast.makeText(context, "my receiver batter $level", Toast.LENGTH_SHORT).show()
        }else if(intent.action == "abcdef"){
            Toast.makeText(context, "abcdef", Toast.LENGTH_SHORT).show()
        }
    }
}
