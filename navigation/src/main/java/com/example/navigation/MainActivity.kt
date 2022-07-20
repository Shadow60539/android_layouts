package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
//    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        drawerLayout = findViewById(R.id.drawer)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.profileFragment))
//        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.profileFragment), drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
//        attachNavControllerToDrawer()
        attachNavControllerToBottomNavigationView()
    }

//    private fun attachNavControllerToDrawer() {
//        findViewById<NavigationView>(R.id.navigationView).setupWithNavController(navController)
//    }

    private fun attachNavControllerToBottomNavigationView() {
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) ||super.onSupportNavigateUp()
    }
}