package com.recursia.navigationciceroneexample.fragments

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.recursia.navigationciceroneexample.R
import com.recursia.navigationciceroneexample.common.BackButtonListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SellFragment : Fragment(R.layout.fragment_sell), BackButtonListener {

    @Inject
    lateinit var router: Router

    override fun onBackPressed() {
        router.exit()
    }

    companion object {
        fun newInstance() = SellFragment()
    }
}