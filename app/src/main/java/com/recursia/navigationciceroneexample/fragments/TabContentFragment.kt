package com.recursia.navigationciceroneexample.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.recursia.navigationciceroneexample.R
import com.recursia.navigationciceroneexample.Screens
import com.recursia.navigationciceroneexample.common.BackButtonListener
import com.recursia.navigationciceroneexample.common.LocalCiceroneHolder
import com.recursia.navigationciceroneexample.getChainText
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TabContentFragment : Fragment(R.layout.fragment_tab), BackButtonListener {

    private lateinit var tabName: String
    private var chainCounter: Int = 0

    private lateinit var title: TextView
    private lateinit var chainTextView: TextView
    private lateinit var openNextScreen: Button
    private lateinit var openSellScreen: Button

    @Inject
    lateinit var globalRouter: Router

    @Inject
    lateinit var ciceroneHolder: LocalCiceroneHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        tabName = args.getString(TAB_NAME_ARG)!!
        chainCounter = args.getInt(CHAIN_COUNTER_ARG)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            title = findViewById(R.id.title)
            openNextScreen = findViewById(R.id.go_next_button)
            openSellScreen = findViewById(R.id.open_sell_screen)
            chainTextView = findViewById(R.id.screen_chain)
        }
        title.text = tabName
        chainTextView.text = getChainText(chainCounter)


        openNextScreen.setOnClickListener {
            ciceroneHolder.getCicerone(tabName).router.navigateTo(
                Screens.TabFragment(
                    tabName,
                    chainCounter + 1
                )
            )
        }
        openSellScreen.setOnClickListener {
            globalRouter.navigateTo(Screens.SellScreen())
        }
    }

    override fun onBackPressed(): Boolean {
        ciceroneHolder.getCicerone(tabName).router.exit()
        return true
    }

    companion object {
        private const val TAB_NAME_ARG = "TAB_NAME_ARG"
        private const val CHAIN_COUNTER_ARG = "CHAIN_TEXT_ARG"

        fun newInstance(tabName: String, chainCount: Int = 1) = TabContentFragment().apply {
            arguments = Bundle().apply {
                putString(TAB_NAME_ARG, tabName)
                putInt(CHAIN_COUNTER_ARG, chainCount)
            }
        }
    }
}