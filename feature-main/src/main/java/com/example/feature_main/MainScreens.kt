package com.example.feature_main

import com.example.feature_main.fragments.MainFragment
import com.example.feature_main.fragments.TabContentFragment
import com.example.feature_main.fragments.WelcomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object MainScreens {
    fun MainScreen() = FragmentScreen { MainFragment.newInstance() }
    fun TabFragment(tabName: String, chainCount: Int = 1) =
        FragmentScreen { TabContentFragment.newInstance(tabName, chainCount) }
    fun WelcomeScreen(chainCount: Int = 1) =
        FragmentScreen { WelcomeFragment.newInstance(chainCount) }
}