package project.adrian.com.android_kotlin_jetpack_example

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object NotificationId {
        val SIMPLE_NOTIFICATION = 0
        val EXPANDABLE_NOTIFICATION = 1
        val MULTIPLE_LINES_NOTIFICATION = 2
        val IMAGES_NOTIFICATION = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSimpleNotificationChannel()
        val simpleNotificationBuilder = createSimpleNotification()
        btnSimpleNotification.setOnClickListener {
            val notificationManager = NotificationManagerCompat.from(this)
            notificationManager.notify(SIMPLE_NOTIFICATION, simpleNotificationBuilder.build())
        }

        createExpandableNotificationChannel()
        val expandableNotificationBuilder = createExpandableNotification()
        btnExpandableNotification.setOnClickListener {
            val notificationManager = NotificationManagerCompat.from(this)
            notificationManager.notify(EXPANDABLE_NOTIFICATION, expandableNotificationBuilder.build())
        }

        createMultipleLinesNotificationChannel()
        val multipleLinesNotificationBuilder = createMultipleLinesNotification()
        btnMultipleLinesNotification.setOnClickListener {
            val notificationManager = NotificationManagerCompat.from(this)
            notificationManager.notify(MULTIPLE_LINES_NOTIFICATION, multipleLinesNotificationBuilder.build())
        }

        createImagesNotificationChannel()
        val imagesNotificationBuilder = createImagesNotification()
        btnImagesNotification.setOnClickListener {
            val notificationManager = NotificationManagerCompat.from(this)
            notificationManager.notify(IMAGES_NOTIFICATION, imagesNotificationBuilder.build())
        }

    }

    private fun createSimpleNotification(): NotificationCompat.Builder {
        val intent = Intent(this, SecondActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builder = NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.notification_template_icon_bg)
                .setContentTitle("Simpe notification")
                .setContentText("Open second activiy bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        return builder
    }

    private fun createSimpleNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel_name"
            val description = "channel_description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel_id", name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }

    private fun createExpandableNotification(): NotificationCompat.Builder {
        val intent = Intent(this, SecondActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builder = NotificationCompat.Builder(this, "channel_id2")
                .setSmallIcon(R.drawable.notification_template_icon_bg)
                .setContentTitle("Expandable notification")
                .setContentText("Open second activiy")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line, bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla ..."))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        return builder
    }

    private fun createExpandableNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel_name"
            val description = "channel_description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel_id2", name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }

    private fun createMultipleLinesNotification(): NotificationCompat.Builder {
        val intent = Intent(this, SecondActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builder = NotificationCompat.Builder(this, "channel_id3")
                .setSmallIcon(R.drawable.notification_template_icon_bg)
                .setContentTitle("Multiple lines notification")
                .setContentText("Open second activiy")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(NotificationCompat.InboxStyle()
                        .addLine("asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd asd")
                        .addLine("bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla")
                        .addLine("cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb cvb"))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        return builder
    }

    private fun createMultipleLinesNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel_name"
            val description = "channel_description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel_id3", name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }

    private fun createImagesNotification(): NotificationCompat.Builder {
        val intent = Intent(this, SecondActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builder = NotificationCompat.Builder(this, "channel_id4")
                .setSmallIcon(R.drawable.notification_template_icon_bg)
                .setContentTitle("Multiple lines notification")
                .setContentText("Open second activiy")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.abc_ic_arrow_drop_right_black_24dp))
                .setStyle(NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.ic_mtrl_chip_checked_black)))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        return builder
    }

    private fun createImagesNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel_name"
            val description = "channel_description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel_id4", name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }
}
