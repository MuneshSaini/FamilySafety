package com.muneshsaini.familysafety

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Activity_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Bottombar = findViewById<BottomNavigationView>(R.id.bottombar)
        Bottombar.setOnItemSelectedListener {

            if(it.itemId == R.id.nav_home){
                inflateFragment(HomeFragment.newInstance())
            }
            if(it.itemId == R.id.nav_guard){
                inflateGuard()
            }
            if (it.itemId == R.id.nav_dashboard){
                inflateFragment(Dashboard_Fragment.newInstance())
            }
            if(it.itemId == R.id.nav_profile){
                inflateFragment(Profile_Fragment.newInstance())
            }
              true
          }

        }

    private fun inflateFragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()
    }
    //this is the basic function for iflate the fragment guard
    //we can make different different functions for every single fragment activity but for reduse the length of words we are using upper function
    //using inflateFragment function and passsing newInstance as parameter we can call different different fragment activity using single function
    private fun inflateGuard() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,Guard_fragment.newInstance())
        transaction.commit()
    }
}