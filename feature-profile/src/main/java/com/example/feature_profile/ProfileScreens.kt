package com.example.feature_profile

import com.example.feature_profile.activities.ProfileActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen

object ProfileScreens {
    fun ProfileScreen() = ActivityScreen { ProfileActivity.getLaunchIntent(it) }
}