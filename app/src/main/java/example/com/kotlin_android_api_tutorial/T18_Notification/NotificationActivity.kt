package example.com.kotlin_android_api_tutorial.T18_Notification

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    private val CHANNEL_ID = "T18_Notification.news"

    private var notificationManager: NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel(CHANNEL_ID, "NotifyDemo News", "Example News Channel")

        btnNotification.setOnClickListener {
            sendNotification()
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(id: String, name: String,
                                          description: String) {

        val importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(id, name, importance)

        channel.description = description
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern =
            longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationManager?.createNotificationChannel(channel)
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun sendNotification() {

        val notificationID = 101
        val resultIntent = Intent(this, ResultActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            resultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val icon: Icon = Icon.createWithResource(this, android.R.drawable.ic_dialog_info)

        val action: Notification.Action =
            Notification.Action.Builder(icon, "Open", pendingIntent).build()


        val notification = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("Example Notification")
            .setContentText("This is an  example notification.")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setChannelId(CHANNEL_ID)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setActions(action)
            .build()

        notificationManager?.notify(notificationID, notification)

//        val GROUP_KEY_NOTIFY = "group_key_notify"
//
//        var builderSummary: Notification.Builder = Notification.Builder(this, CHANNEL_ID)
//            .setSmallIcon(android.R.drawable.ic_dialog_info)
//            .setContentTitle("A Bundle Example")
//            .setContentText("You have 3 new messages")
//            .setGroup(GROUP_KEY_NOTIFY)
//            .setGroupSummary(true)
//
//        var builder1: Notification.Builder = Notification.Builder(this, CHANNEL_ID)
//            .setSmallIcon(android.R.drawable.ic_dialog_info)
//            .setContentTitle("New Message")
//            .setContentText("You have a new message from Kassidy")
//            .setGroup(GROUP_KEY_NOTIFY)
//
//        var builder2: Notification.Builder = Notification.Builder(this, CHANNEL_ID)
//            .setSmallIcon(android.R.drawable.ic_dialog_info)
//            .setContentTitle("New Message")
//            .setContentText("You have a new message from Caitlyn")
//            .setGroup(GROUP_KEY_NOTIFY)
//
//        var builder3: Notification.Builder = Notification.Builder(this, CHANNEL_ID)
//            .setSmallIcon(android.R.drawable.ic_dialog_info)
//            .setContentTitle("New Message")
//            .setContentText("You have a new message from Jason")
//            .setGroup(GROUP_KEY_NOTIFY)
//
//        var notificationId0 = 100
//        var notificationId1 = 101
//        var notificationId2 = 102
//        var notificationId3 = 103
//
//        notificationManager?.notify(notificationId1, builder1.build())
//        notificationManager?.notify(notificationId2, builder2.build())
//        notificationManager?.notify(notificationId3, builder3.build())
//        notificationManager?.notify(notificationId0, builderSummary.build())

    }
}
