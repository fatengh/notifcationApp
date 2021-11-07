package com.example.notifcationapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val notificationId = 12223
    private val channelId = "myapp.notifications"
    private val description = "Notification App Example"
    private lateinit var btn: Button
    private lateinit var ed: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btnNoti)
        ed = findViewById(R.id.etNoti)

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager


        btn.setOnClickListener {

            val intent = Intent(this, NotificationActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel =
                    NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_LOW)
                notificationManager.createNotificationChannel(notificationChannel)
                builder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_baseline_account_circle_24)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.drawable.ic_baseline_account_circle_24
                        )
                    )
                    .setContentIntent(pendingIntent)
                    .setContentTitle("Notification App")
                    .setContentText(ed.text!!)
            } else {
                builder = Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_baseline_account_circle_24)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.drawable.ic_baseline_account_circle_24
                        )
                    )
                    .setContentIntent(pendingIntent)
                    .setContentTitle(" Notification App")
                    .setContentText(ed.text!!)
            }
            notificationManager.notify(notificationId, builder.build())


        }

    }
}