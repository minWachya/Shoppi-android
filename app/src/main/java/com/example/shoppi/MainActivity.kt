package com.example.shoppi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.navigation_main)
        bottomNavigation.itemIconTintList = null    // Theme의 color로 아이콘 색 표시 X, drawable 그대로 사용

        // FragmentContainerView의 NavController가져와서 bottomNavigation에 전달
        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let { bottomNavigation.setupWithNavController(it) }
    }
}