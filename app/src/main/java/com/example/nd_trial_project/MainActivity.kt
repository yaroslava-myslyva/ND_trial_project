package com.example.nd_trial_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.nd_trial_project.databinding.ActivityMainBinding

const val TAG = "ttt"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavController()
    }

    private fun setupNavController() {
        val navController = binding.navHostFragment.getFragment<NavHostFragment>().navController
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.destination_gallery_fragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}