package com.recursia.navigationciceroneexample.domain

interface WelcomeRepository {
    var isScenarioFinished: Boolean

    var savedStepIndex: Int
}