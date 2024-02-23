package com.muneshsaini.familysafety

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Activity_main : AppCompatActivity() {


   val permissions = arrayOf(

       android.Manifest.permission.ACCESS_FINE_LOCATION,
       android.Manifest.permission.ACCESS_COARSE_LOCATION
   )
    val PermissionCode = 78
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        askForPermission()

        var Bottombar = findViewById<BottomNavigationView>(R.id.bottombar)
        Bottombar.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.nav_home -> {
                    inflateFragment(HomeFragment.newInstance())
                }
            }
            if(it.itemId == R.id.nav_guard){
                inflateGuard()
            }
            if (it.itemId == R.id.nav_dashboard){
                inflateFragment(MapsFragment())
            }
            if(it.itemId == R.id.nav_profile){
                inflateFragment(Profile_Fragment.newInstance())
            }
              true
          }
          Bottombar.selectedItemId = R.id.nav_home
        }

    private fun askForPermission() {
        ActivityCompat.requestPermissions(this,permissions,PermissionCode)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    { super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == PermissionCode) {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText( this,  "Permission Granted", Toast.LENGTH_SHORT).show()
            else askForPermission()
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