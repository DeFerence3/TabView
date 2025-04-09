package com.udyata.amrita.main.data.location

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.udyata.amrita.main.data.location.GpsTracker


fun getLatLong(context: Context) {

    val gpsTracker: GpsTracker = GpsTracker(context)

    try {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                101
            )
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

    if (gpsTracker.canGetLocation()) {
        val latitude: Double = gpsTracker.getLatitude()
        val longitude: Double = gpsTracker.getLongitude()

        println(latitude)
        println(longitude)


    } else {
        gpsTracker.showSettingsAlert()
    }
}