package com.example.currencyconvert.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.currencyconvert.R
import com.example.currencyconvert.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null

    private val appBarConfiguration = AppBarConfiguration(
        setOf(
            R.id.currencyValueFragment,
            R.id.historyCurrencyValueFragment,
            R.id.currencyConverterFragment
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        navController = findNavController(R.id.nav_host_fragment)

        navController?.let { navController ->
            binding.bottomNavigation.setOnItemReselectedListener { itemMenu ->
                val selectedMenuItemGraph =
                    navController.graph.findNode(itemMenu.itemId) as? NavGraph?

                selectedMenuItemGraph?.let { navGraph ->
                    navController.popBackStack(navGraph.startDestinationId, false)
                }
            }
            binding.bottomNavigation.setupWithNavController(navController)
            setupActionBarWithNavController(navController, appBarConfiguration)
        }
    }

  override fun onSupportNavigateUp(): Boolean {
      return navController?.navigateUp(appBarConfiguration)?: true
  }


}


