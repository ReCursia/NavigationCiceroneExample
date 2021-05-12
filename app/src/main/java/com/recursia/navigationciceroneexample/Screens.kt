package com.recursia.navigationciceroneexample

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.recursia.navigationciceroneexample.fragments.*

object Screens {
    fun IntroScreen() = FragmentScreen { IntroFragment.newInstance() }
    fun MainScreen() = FragmentScreen { MainFragment.newInstance() }
    fun SellScreen() = FragmentScreen { SellFragment.newInstance() }

    fun WelcomeScreen(chainCount: Int = 1) =
        FragmentScreen { WelcomeFragment.newInstance(chainCount) }

    fun TabFragment(tabName: String, chainCount: Int = 1) =
        FragmentScreen { TabContentFragment.newInstance(tabName, chainCount) }
}