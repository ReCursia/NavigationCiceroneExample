package com.example.feature_main.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.feature_main.MainScreens
import com.example.feature_main.R
import com.example.feature_main.domain.WelcomeRepository
import com.github.terrakok.cicerone.Router
import com.recursia.navigation.common.BackButtonListener
import com.recursia.utils.getChainText
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeFragment : Fragment(R.layout.fragment_welcome), BackButtonListener {

    private var chainCounter: Int = 0

    private lateinit var openNext: Button
    private lateinit var chainTextView: TextView
    private lateinit var finishWelcome: Button

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var welcomeRepository: WelcomeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        chainCounter = args.getInt(CHAIN_COUNTER_ARG)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        welcomeRepository.savedStepIndex = chainCounter

        with(view) {
            openNext = findViewById(R.id.go_next_button)
            chainTextView = findViewById(R.id.screen_chain)
            finishWelcome = findViewById(R.id.finish_welcome_scenario)
        }
        chainTextView.text = getChainText(chainCounter)
        openNext.setOnClickListener {
            router.navigateTo(MainScreens.WelcomeScreen(chainCounter + 1))
        }
        finishWelcome.setOnClickListener {
            router.newRootScreen(MainScreens.MainScreen())
            welcomeRepository.isScenarioFinished = true
        }
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    companion object {

        private const val CHAIN_COUNTER_ARG = "CHAIN_COUNTER_ARG"

        fun newInstance(chainCount: Int = 1) = WelcomeFragment().apply {
            arguments = Bundle().apply {
                putInt(
                    CHAIN_COUNTER_ARG, chainCount
                )
            }
        }
    }
}