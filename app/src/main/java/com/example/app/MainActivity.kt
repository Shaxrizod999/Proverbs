package com.example.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AlertDialog.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import com.example.app.R.id.nav_slideshow
import com.example.app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        val bottomNavigationView:BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNavigationView.setupWithNavController(navController)

        findViewById<ImageView>(R.id.navigationdrawer).setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment, R.id.nav_gallery, nav_slideshow
        ), drawerLayout)
        navView.setupWithNavController(findNavController(R.id.nav_host_fragment))

        search.setOnClickListener {
            val intent =Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }

        navView.setNavigationItemSelectedListener {menuItem ->

            when(menuItem.itemId){
                R.id.dastur_haqida->{
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    val dialog = AlertDialog.Builder(this).create()
                    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_view1,null,false)
                    dialog.setView(dialogView)
                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                    dialog.show()
                }
                R.id.nav_gallery->{
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    val intent =Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                    //val layout:DrawerLayout = findViewById(R.id.drawer_layout)
                }
                R.id.nav_slideshow->{
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    val intent =Intent(this, ThirdActivity::class.java)
                    startActivity(intent)
                }
                R.id.ulashish->{
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    val intent= Intent()
                    intent.action=Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,"Hey Check out this Great app:")
                    intent.type="text/plain"
                    startActivity(Intent.createChooser(intent,"Share To:"))
                }
            }
            true
        }
    }
    override fun onBackPressed() {
        val layout:DrawerLayout = findViewById(R.id.drawer_layout)
        if (layout.isDrawerOpen(GravityCompat.START)){
            layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_drawer, menu)
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}