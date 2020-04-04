package net.remenkoff.joke

import android.app.IntentService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class DelayedMessageService : IntentService("DelayedMessageService") {

    companion object {
        const val EXTRA_MESSAGE = "message"
        const val NOTIFICATION_ID = 5453
        const val CHANNEL_ID = "default"
        const val CHANNEL_NAME = "MyDefaultChannel"
    }

    override fun onHandleIntent(intent: Intent?) {
        synchronized(this) {
            try {
                Thread.sleep(10 * 1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        val text = intent?.getStringExtra(EXTRA_MESSAGE) ?: return

        showText(text)
    }

    private fun showText(text: String) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.sym_def_app_icon)
            .setContentTitle(getString(R.string.question))
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setVibrate(longArrayOf(0, 1000))
            .setAutoCancel(true)

        val actionIntent = Intent(this, MainActivity::class.java)
        val actionPendingIntent = PendingIntent.getActivity(
            this,
            0,
            actionIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        builder.setContentIntent(actionPendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }
}
