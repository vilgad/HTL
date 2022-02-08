package com.example.bottomnavigationview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView  = findViewById(R.id.bottomNavigationView)

        title = resources.getString(R.string.favourite)
        loadFragment(FirstFragment())


       navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.firstFragment -> {
                   title = "firstFragment"
                    loadFragment(FirstFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.secondFragment -> {
                    title = "secondFragment"
                    loadFragment(SecondFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.thirdFragment -> {
                    title = "thirdFragment"
                    loadFragment(ThirdFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.fourthFragment -> {
                    title = "fourthFragment"
                    loadFragment(fourthFragment())
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}