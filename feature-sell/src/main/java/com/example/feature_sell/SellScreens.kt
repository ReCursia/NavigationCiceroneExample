package com.example.feature_sell

import com.example.feature_sell.fragments.SellFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SellScreens {
    fun SellScreen() = FragmentScreen { SellFragment.newInstance() }
}