package com.recursia.navigationciceroneexample.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.recursia.navigationciceroneexample.R
import com.recursia.navigationciceroneexample.Screens
import com.recursia.navigationciceroneexample.common.BackButtonListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class IntroFragment : Fragment(R.layout.fragment_intro), BackButtonListener {

    private lateinit var openWelcomeScreenButton: Button
    private lateinit var openMainScreenButton: Button

    @Inject
    lateinit var router: Router

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            openWelcomeScreenButton = findViewById(R.id.open_welcome_screen_button)
            openMainScreenButton = findViewById(R.id.open_main_screen_button)
        }

        openWelcomeScreenButton.setOnClickListener {
            router.newRootScreen(Screens.WelcomeScreen())
        }

        openMainScreenButton.setOnClickListener {
            router.newRootScreen(Screens.MainScreen())
        }

    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    companion object {
        fun newInstance() = IntroFragment()
    }
}