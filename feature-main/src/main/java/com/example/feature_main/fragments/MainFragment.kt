package com.example.feature_main.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.feature_main.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.recursia.navigation.common.BackButtonListener

class MainFragment : Fragment(R.layout.fragment_main), BackButtonListener {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigation = view.findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener {
            selectTab(getSelectedTabTag(it.itemId))
            true
        }
        bottomNavigation.setOnNavigationItemReselectedListener {
            selectTab(getSelectedTabTag(it.itemId))
        }
        if (savedInstanceState == null && !isTabFragmentVisible()) {
            selectTab(getString(R.string.first_tab_title))
        }
    }

    override fun onBackPressed(): Boolean {
        val selectedTabTag = getSelectedTabTag(bottomNavigation.selectedItemId)
        val fragment = childFragmentManager.findFragmentByTag(selectedTabTag)
        return fragment != null && fragment is BackButtonListener && fragment.onBackPressed()
    }

    private fun getSelectedTabTag(@IdRes itemId: Int) = when (itemId) {
        R.id.tab_1 -> getString(R.string.first_tab_title)
        R.id.tab_2 -> getString(R.string.second_tab_title)
        R.id.tab_3 -> getString(R.string.third_tab_title)
        else -> throw IllegalStateException("Undefined menu item")
    }

    private fun isTabFragmentVisible() = childFragmentManager.fragments.isNotEmpty()

    private fun selectTab(tabName: String) {
        val fm = childFragmentManager
        var currentFragment: Fragment? = null
        val fragments = fm.fragments
        for (f in fragments) {
            if (f.isVisible) {
                currentFragment = f
                break
            }
        }
        val newFragment = fm.findFragmentByTag(tabName)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return
        val transaction = fm.beginTransaction()
        if (newFragment == null) {
            transaction.add(
                R.id.tab_container,
                TabContainerFragment.newInstance(tabName),
                tabName
            )
        }
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        if (newFragment != null) {
            transaction.show(newFragment)
        }
        transaction.commitNow()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}