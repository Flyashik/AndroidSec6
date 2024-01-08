/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.treasureHunt

import android.content.Context
import com.google.android.gms.location.GeofenceStatusCodes
import com.google.android.gms.maps.model.LatLng
import java.util.concurrent.TimeUnit

/**
 * Returns the error string for a geofencing error code.
 */
fun errorMessage(context: Context, errorCode: Int): String {
    val resources = context.resources
    return when (errorCode) {
        GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE -> resources.getString(
            R.string.geofence_not_available
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES -> resources.getString(
            R.string.geofence_too_many_geofences
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS -> resources.getString(
            R.string.geofence_too_many_pending_intents
        )
        else -> resources.getString(R.string.unknown_geofence_error)
    }
}

/**
 * Stores latitude and longitude information along with a hint to help user find the location.
 */
data class LandmarkDataObject(val id: String, val hint: Int, val name: Int, val latLong: LatLng)

internal object GeofencingConstants {

    /**
     * Used to set an expiration time for a geofence. After this amount of time, Location services
     * stops tracking the geofence. For this sample, geofences expire after one hour.
     */
    val GEOFENCE_EXPIRATION_IN_MILLISECONDS: Long = TimeUnit.HOURS.toMillis(1)

    val LANDMARK_DATA = arrayOf(

        LandmarkDataObject(
            "enter",
            R.string.enter_hint,
            R.string.enter_location,
            LatLng(47.21689192142189,39.62897267192602)),

        LandmarkDataObject(
            "corner",
            R.string.corner_hint,
            R.string.corner_location,
            LatLng(47.21710188614177,39.628587774932384)),

        LandmarkDataObject(
            "corner2",
            R.string.corner_2_hint,
            R.string.corner_2_location,
            LatLng(47.21676530455121,39.627951085567474)),

        LandmarkDataObject(
            "corner3",
            R.string.corner_3_hint,
            R.string.corner_3_location,
            LatLng(47.21624949708838,39.6287252381444)),

        LandmarkDataObject(
            "barrier",
            R.string.barrier_hint,
            R.string.barrier_location,
            LatLng(47.21662024132597,39.62933074682951)),

        LandmarkDataObject(
            "smoking_place",
            R.string.smoking_place_hint,
            R.string.smoking_place_location,
            LatLng(47.21692721923663,39.62891299277544))
    )

    val NUM_LANDMARKS = LANDMARK_DATA.size
    const val GEOFENCE_RADIUS_IN_METERS = 20f
    const val EXTRA_GEOFENCE_INDEX = "GEOFENCE_INDEX"
}
