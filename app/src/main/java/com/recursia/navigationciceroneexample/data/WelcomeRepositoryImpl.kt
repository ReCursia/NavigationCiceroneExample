package com.recursia.navigationciceroneexample.data

import android.content.Context
import com.recursia.navigationciceroneexample.domain.WelcomeRepository
import javax.inject.Inject

class WelcomeRepositoryImpl @Inject constructor(
    private val context: Context
) : WelcomeRepository {

    private val prefs by lazy { context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE) }

    override var isScenarioFinished: Boolean
        get() = prefs.getBoolean(IS_FINISHED, false)
        set(value) {
            prefs.edit().putBoolean(IS_FINISHED, value).apply()
        }

    companion object {
        private const val PREF_NAME = "WELCOME_PREF_NAME"
        private const val IS_FINISHED = "IS_FINISHED"
    }
}