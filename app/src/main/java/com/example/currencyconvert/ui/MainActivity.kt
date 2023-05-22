package com.example.currencyconvert.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.currencyconvert.R
import com.example.currencyconvert.databinding.ActivityMainBinding
import com.example.currencyconvert.ui.allcurrencies.CurrencyValueFragment
import com.example.currencyconvert.ui.converter.CurrencyConverterFragment
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

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.currencyValueFragment -> replaceFragment(CurrencyValueFragment())
                R.id.currencyConverterFragment -> replaceFragment(CurrencyConverterFragment())
                R.id.historyCurrencyValueFragment -> replaceFragment(HistoryCurrencyValueFragment())
                else -> replaceFragment(CurrencyValueFragment())
            }
            true
        }

        replaceFragment(CurrencyValueFragment())

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commitNow()
    }
}


