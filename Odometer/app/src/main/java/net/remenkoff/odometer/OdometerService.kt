package net.remenkoff.odometer

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import androidx.core.content.ContextCompat

class OdometerService : Service() {

    inner class OdometerBinder: Binder() {
        fun getOdometer(): OdometerService { return this@OdometerService }
    }

    // MARK: - Private Type Properties
    companion object {
        const val PERMISSION_STRING = android.Manifest.permission.ACCESS_FINE_LOCATION
        const val GRANTED = PackageManager.PERMISSION_GRANTED

        private var distanceInMeters: Double = 0.0
        private var lastLocation: Location? = null
    }

    // MARK: - Private Instance Properties
    private val binder: IBinder = OdometerBinder()
    private var locationManager: LocationManager? = null
    private var listener: LocationListener? = null

    // MARK: - Service Lifecycle
    override fun onCreate() {
        super.onCreate()

        listener = object : LocationListener {
            override fun onLocationChanged(location: Location?) {
                if (lastLocation == null) {
                    lastLocation = location
                }

                if (location != null) {
                    distanceInMeters += location.distanceTo(lastLocation)
                    lastLocation = location
                }
            }

            override fun onProviderDisabled(provider: String?) {}
            override fun onProviderEnabled(provider: String?) {}
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
        }

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (ContextCompat.checkSelfPermission(this, PERMISSION_STRING) == GRANTED) {
            val provider: String? = locationManager?.getBestProvider(Criteria(), true)

            if (provider != null) {
                locationManager?.requestLocationUpdates(provider, 1000, 1.0.toFloat(), listener!!)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onDestroy() {
        super.onDestroy()

        if (locationManager == null || listener == null) {
            return
        }

        if (ContextCompat.checkSelfPermission(this, PERMISSION_STRING) == GRANTED) {
            locationManager?.removeUpdates(listener!!)
        }

        locationManager = null
        listener = null
    }

    // MARK: - Public Instance Interface
    fun getDistance(): Double {
        return distanceInMeters / 1609.34
    }
}
