package com.recursia.navigationciceroneexample.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.recursia.navigationciceroneexample.R

class ProfileActivity : AppCompatActivity(R.layout.activity_profile) {

    companion object {
        fun getLaunchIntent(context: Context) =
            Intent(context, ProfileActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
    }
}