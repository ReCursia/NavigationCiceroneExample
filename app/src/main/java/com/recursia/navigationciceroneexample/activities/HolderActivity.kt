package com.recursia.navigationciceroneexample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.recursia.navigationciceroneexample.R
import com.recursia.navigationciceroneexample.Screens
import com.recursia.navigationciceroneexample.common.BackButtonListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HolderActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = object : AppNavigator(this, R.id.container) {

        override fun applyCommandsSync(commands: Array<out Command>) {
            super.applyCommandsSync(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if (savedInstanceState == null) {
            navigator.applyCommands(arrayOf(Replace(Screens.IntroScreen())))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onResumeFragments() {
        navigatorHolder.setNavigator(navigator)
        super.onResumeFragments()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        var fragment: Fragment? = null
        val fragments = fm.fragments
        for (f in fragments) {
            if (f.isVisible) {
                fragment = f
                break
            }
        }
        if (fragment != null && fragment is BackButtonListener && fragment.onBackPressed()) {
            return
        } else {
            super.onBackPressed()
        }
    }
}