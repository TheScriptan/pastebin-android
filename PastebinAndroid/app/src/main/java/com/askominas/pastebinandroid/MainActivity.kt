package com.askominas.pastebinandroid

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.askominas.pastebinandroid.core.AppPreferences
import com.askominas.pastebinandroid.core.AuthenticationState
import com.askominas.pastebinandroid.core.DEFAULT_USER_KEY
import com.askominas.pastebinandroid.databinding.ActivityMainBinding
import org.koin.java.KoinJavaComponent.inject

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private val preferences: AppPreferences by inject(AppPreferences::class.java)
    private val authenticationState: AuthenticationState by inject(AuthenticationState::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        navController = findNavController(R.id.nav_main)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.createPasteFragment,
            R.id.listPasteFragment
        ).build()
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val signInItem = menu?.findItem(R.id.signInFragment)
        val logOutItem = menu?.findItem(R.id.logOutItem)

        signInItem?.isVisible = !authenticationState.isLoggedIn
        logOutItem?.isVisible = authenticationState.isLoggedIn

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.logOutItem) {
            preferences.userKey = DEFAULT_USER_KEY
            Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show()
            return true
        }

        return NavigationUI.onNavDestinationSelected(
            item!!,
            navController
        ) || super.onOptionsItemSelected(item)
    }
}
