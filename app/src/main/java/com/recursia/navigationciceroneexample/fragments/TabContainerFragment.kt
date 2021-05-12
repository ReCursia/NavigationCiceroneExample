package com.recursia.navigationciceroneexample.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.recursia.navigationciceroneexample.R
import com.recursia.navigationciceroneexample.Screens
import com.recursia.navigationciceroneexample.common.BackButtonListener
import com.recursia.navigationciceroneexample.common.LocalCiceroneHolder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TabContainerFragment : Fragment(R.layout.container), BackButtonListener {

    private lateinit var tabName: String

    private val navigator: Navigator by lazy {
        AppNavigator(requireActivity(), R.id.container, childFragmentManager)
    }

    @Inject
    lateinit var localCiceroneHolder: LocalCiceroneHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        tabName = args.getString(TAB_NAME_ARG)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            localCiceroneHolder.getCicerone(tabName).router.replaceScreen(
                Screens.TabFragment(
                    tabName
                )
            )
        }
    }

    override fun onResume() {
        super.onResume()
        localCiceroneHolder.getCicerone(tabName).getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        localCiceroneHolder.getCicerone(tabName).getNavigatorHolder().removeNavigator()
        super.onPause()
    }

    override fun onBackPressed(): Boolean {
        val fragment = childFragmentManager.findFragmentById(R.id.container)
        return fragment != null && fragment is BackButtonListener && fragment.onBackPressed()
    }

    companion object {
        private const val TAB_NAME_ARG = "TAB_NAME_ARG"

        fun newInstance(tabName: String) = TabContainerFragment().apply {
            arguments = Bundle().apply {
                putString(TAB_NAME_ARG, tabName)
            }
        }
    }
}