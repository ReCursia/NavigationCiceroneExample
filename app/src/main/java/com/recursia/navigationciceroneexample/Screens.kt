package com.recursia.navigationciceroneexample

import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.recursia.navigationciceroneexample.activities.ProfileActivity
import com.recursia.navigationciceroneexample.fragments.MainFragment
import com.recursia.navigationciceroneexample.fragments.SellFragment
import com.recursia.navigationciceroneexample.fragments.TabContentFragment
import com.recursia.navigationciceroneexample.fragments.WelcomeFragment

object Screens {
    fun MainScreen() = FragmentScreen { MainFragment.newInstance() }
    fun SellScreen() = FragmentScreen { SellFragment.newInstance() }
    fun ProfileScreen() = ActivityScreen { ProfileActivity.getLaunchIntent(it) }

    fun WelcomeScreen(chainCount: Int = 1) =
        FragmentScreen { WelcomeFragment.newInstance(chainCount) }

    fun TabFragment(tabName: String, chainCount: Int = 1) =
        FragmentScreen { TabContentFragment.newInstance(tabName, chainCount) }
}