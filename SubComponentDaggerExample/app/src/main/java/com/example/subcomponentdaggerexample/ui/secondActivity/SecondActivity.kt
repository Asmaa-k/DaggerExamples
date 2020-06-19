package com.example.subcomponentdaggerexample.ui.secondActivity

import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.subcomponentdaggerexample.R
import com.google.android.material.navigation.NavigationView
import dagger.android.support.DaggerAppCompatActivity

class SecondActivity : DaggerAppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        init()
    }


    private fun init() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.homeFragment -> {
                // nav options to clear backstack
                val navOptions = NavOptions.Builder().setPopUpTo(R.id.main, true).build()
                Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.homeFragment, null, navOptions)
            }

            R.id.id_one-> {
                if (isValidDestination(R.id.fragmentOne)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.fragmentOne)
                }
            }

            R.id.id_two -> {
                if (isValidDestination(R.id.fragmentTwo)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.fragmentTwo)
                }
            }

        }
        return true
    }

    fun isValidDestination(destination: Int): Boolean = destination != Navigation.findNavController(
        this,
        R.id.nav_host_fragment
    ).currentDestination!!.id

    //to enable the back arrow
    override fun onSupportNavigateUp(): Boolean = NavigationUI.navigateUp(
        Navigation.findNavController(
            this, R.id.nav_host_fragment
        ), drawerLayout
    )

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
                return true
            } else {
                return false
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}