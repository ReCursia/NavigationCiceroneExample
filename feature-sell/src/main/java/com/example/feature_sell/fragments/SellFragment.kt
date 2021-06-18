package com.example.feature_sell.fragments

import androidx.fragment.app.Fragment
import com.example.feature_sell.R
import com.github.terrakok.cicerone.Router
import com.recursia.navigation.common.BackButtonListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SellFragment : Fragment(R.layout.fragment_sell), BackButtonListener {

    @Inject
    lateinit var router: Router

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    companion object {
        fun newInstance() = SellFragment()
    }
}