package com.example.feature_main.data

import android.content.Context
import com.example.feature_main.domain.WelcomeRepository
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

    override var savedStepIndex: Int
        get() = prefs.getInt(SAVED_STEP_INDEX, 1)
        set(value) {
            prefs.edit().putInt(SAVED_STEP_INDEX, value).apply()
        }

    companion object {
        private const val PREF_NAME = "WELCOME_PREF_NAME"
        private const val IS_FINISHED = "IS_FINISHED"
        private const val SAVED_STEP_INDEX = "SAVED_STEP_INDEX"
    }
}