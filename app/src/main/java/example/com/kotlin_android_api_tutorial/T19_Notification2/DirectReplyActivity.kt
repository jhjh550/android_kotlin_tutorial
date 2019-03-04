package example.com.kotlin_android_api_tutorial.T19_Notification2

import android.annotation.TargetApi
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import example.com.kotlin_android_api_tutorial.R
import android.app.NotificationManager
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_direct_reply.*

class DirectReplyActivity : AppCompatActivity() {

    private var notificationManager: NotificationManager? = null
    private val channelID = "T19_Notification2.news"
    private val notificationId = 101
    private val KEY_TEXT_REPLY = "key_text_reply"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_direct_reply)

        btnSendDirectReply.setOnClickListener {
            sendNotification()
        }


        notificationManager =
            getSystemService(
                Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel(channelID, "DirectReply News", "Example News Channel")

        handleIntent()
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun handleIntent() {

        val intent = this.intent

        val remoteInput = RemoteInput.getResultsFromIntent(intent)

        if (remoteInput != null) {

            val inputString = remoteInput.getCharSequence(
                KEY_TEXT_REPLY).toString()

            btnSendDirectReply.text = inputString

            val repliedNotification = Notification.Builder(this, channelID)
                .setSmallIcon(
                    android.R.drawable.ic_dialog_info)
                .setContentText("Reply received")
                .build()

            notificationManager?.notify(notificationId,
                repliedNotification)

        }
    }


    @TargetApi(Build.VERSION_CODES.O)
    fun sendNotification() {

        val replyLabel = "Enter your reply here"
        val remoteInput = RemoteInput.Builder(KEY_TEXT_REPLY)
            .setLabel(replyLabel)
            .build()

        val resultIntent = Intent(this, DirectReplyActivity::class.java)

        val resultPendingIntent = PendingIntent.getActivity(
            this,
            0,
            resultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val icon = Icon.createWithResource(this@DirectReplyActivity,
            android.R.drawable.ic_dialog_info)

        val replyAction = Notification.Action.Builder(
            icon,
            "Reply", resultPendingIntent)
            .addRemoteInput(remoteInput)
            .build()

        val newMessageNotification = Notification.Builder(this, channelID)
            .setColor(
                ContextCompat.getColor(this,
                R.color.colorPrimary))
            .setSmallIcon(
                android.R.drawable.ic_dialog_info)
            .setContentTitle("My Notification")
            .setContentText("This is a test message")
            .setAutoCancel(true)
            .addAction(replyAction).build()

        notificationManager?.notify(notificationId,
            newMessageNotification)
    }


    @TargetApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(id: String,
                                          name: String, description: String) {

        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(id, name, importance)

        channel.description = description
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern =
            longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)


        notificationManager?.createNotificationChannel(channel)
    }
}
