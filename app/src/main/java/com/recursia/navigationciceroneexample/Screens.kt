package com.recursia.navigationciceroneexample

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.recursia.navigationciceroneexample.fragments.IntroFragment
import com.recursia.navigationciceroneexample.fragments.MainFragment
import com.recursia.navigationciceroneexample.fragments.WelcomeFragment

object Screens {
    fun IntroScreen() = FragmentScreen { IntroFragment.newInstance() }
    fun MainScreen() = FragmentScreen { MainFragment.newInstance() }
    fun WelcomeScreen(chainCount: Int = 1) =
        FragmentScreen { WelcomeFragment.newInstance(chainCount) }
}