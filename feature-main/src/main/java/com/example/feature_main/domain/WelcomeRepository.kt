package com.example.feature_main.domain

interface WelcomeRepository {
    var isScenarioFinished: Boolean

    var savedStepIndex: Int
}