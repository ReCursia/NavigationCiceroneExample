package com.recursia.navigationciceroneexample.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.recursia.navigationciceroneexample.R
import com.recursia.navigationciceroneexample.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private var chainCounter: Int = 0

    private lateinit var openNext: Button
    private lateinit var chainTextView: TextView
    private lateinit var finishWelcome: Button

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        chainCounter = args.getInt(CHAIN_COUNTER_ARG, CHAIN_TEXT_DEFAULT_VALUE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            openNext = findViewById(R.id.go_next_button)
            chainTextView = findViewById(R.id.screen_chain)
            finishWelcome = findViewById(R.id.finish_welcome_scenario)
        }
        chainTextView.text = getChainText()
        openNext.setOnClickListener {
            router.navigateTo(Screens.WelcomeScreen(++chainCounter))
        }
        finishWelcome.setOnClickListener {
            router.newRootScreen(Screens.MainScreen())
        }
    }

    private fun getChainText() = buildString {
        for (count in 1..chainCounter) {
            if (count == 1) {
                append(count)
            } else {
                append(" → $count")
            }
        }
    }

    companion object {

        private const val CHAIN_COUNTER_ARG = "CHAIN_TEXT_ARG"
        private const val CHAIN_TEXT_DEFAULT_VALUE = 1

        fun newInstance(chainCount: Int = 1) = WelcomeFragment().apply {
            arguments = Bundle().apply {
                putInt(
                    CHAIN_COUNTER_ARG, chainCount
                )
            }
        }
    }
}