package com.example.bottomnavigationview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.bottomnavigationview.databinding.ActivityNavigationExample3Binding
import com.example.bottomnavigationview.databinding.ActivityNavigationExample4Binding
import com.example.bottomnavigationview.fragments.AddFragment

class NavigationExample4Activity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationExample4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationExample4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navBuilder = NavOptions.Builder()
        navBuilder.setEnterAnim(R.anim.fade_in).setExitAnim(R.anim.fade_out)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_example4) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bnvExample4, navController)

        binding.bnvExample4.background = null
        binding.fabExample4.setOnClickListener {
            navController.navigate(R.id.addFragment, null, navBuilder.build())
        }
    }
}