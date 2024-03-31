package com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bcasyariah.com.example.makanbesar.presentation.home_screen.view.FavoriteMealsFragment
import com.example.bcasyariah.com.example.makanbesar.presentation.home_screen.view.FoodCategoriesFragment
import com.example.bcasyariah.com.example.makanbesar.presentation.home_screen.view.RecommendedFragment
import com.example.makanbesar.R
import com.example.makanbesar.databinding.ActivityFoodCategoriesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodCategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodCategoriesBinding

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationMain -> {
                    replaceFragment(FoodCategoriesFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationFavorite -> {
                    replaceFragment(FavoriteMealsFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationRecommended-> {
                    replaceFragment(RecommendedFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener
        )
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}