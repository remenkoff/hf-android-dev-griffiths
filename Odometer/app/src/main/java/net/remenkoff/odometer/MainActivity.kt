package net.remenkoff.odometer

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.os.postDelayed
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val PERMISSION_REQUEST_CODE = 697
        const val CHANNEL_ID = "default"
        const val CHANNEL_NAME = "Default"
        const val NOTIFICATION_ID = 5452
    }

    // MARK: - Private Instance Properties
    private var odometerService: OdometerService? = null
    private var isBounded: Boolean = false
    private val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName, binder: IBinder) {
            val odometerBinder = binder as OdometerService.OdometerBinder
            odometerService = odometerBinder.getOdometer()
            isBounded = true
        }

        override fun onServiceDisconnected(componentName: ComponentName) {
            isBounded = false
        }
    }

    // MARK: - Activity Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayDistance()
    }

    override fun onStart() {
        super.onStart()

        if (ContextCompat.checkSelfPermission(this, OdometerService.PERMISSION_STRING) != OdometerService.GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(OdometerService.PERMISSION_STRING), PERMISSION_REQUEST_CODE)
        } else {
            bindOdometerService()
        }
    }

    override fun onStop() {
        super.onStop()

        if (isBounded) {
            unbindService(serviceConnection)
            isBounded = false
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == OdometerService.GRANTED) {
                    bindOdometerService()
                } else {
                    displayNoPermissionsNotification()
                }
            }
        }
    }

    // MARK: - Private Instance Interface
    private fun bindOdometerService() {
        val intent = Intent(this, OdometerService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private fun displayNoPermissionsNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.sym_def_app_icon)
            .setContentTitle(resources.getString(R.string.app_name))
            .setContentText(resources.getString(R.string.location_permission_required))
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

    private fun displayDistance() {
        val distanceView = findViewById<TextView>(R.id.distance)
        val handler = Handler()
        lateinit var runnable: Runnable
        runnable = Runnable {
            var distance: Double = 0.0

            if (isBounded && odometerService != null) {
                distance = odometerService!!.getDistance()
            }

            val distanceFormatted = String.format(
                Locale.getDefault(),
                "%1$,.2f miles",
                distance
            )

            distanceView.setText(distanceFormatted)
            handler.postDelayed(runnable, 1000)
        }
        handler.post(runnable)
    }
}
