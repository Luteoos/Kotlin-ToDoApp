package io.github.luteoos.todoapp.views.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import com.eightbitlab.rxbus.Bus
import com.luteoos.kotlin.mvvmbaselib.BaseActivityMVVM
import com.luteoos.kotlin.mvvmbaselib.BaseViewModel
import io.github.luteoos.todoapp.R
import io.github.luteoos.todoapp.views.SplashScreen
import io.github.luteoos.todoapp.views.fragments.FragmentLogIn
import io.github.luteoos.todoapp.views.fragments.FragmentRegister
import io.github.luteoos.todoapp.views.fragments.FragmentTimePicker
import kotlinx.android.synthetic.main.activity_navigator_menu.*
import kotlinx.android.synthetic.main.nav_header_user_info_bar.view.*
import kotlinx.android.synthetic.main.nav_layout_fragment.*

class NavigatorMenu : BaseActivityMVVM<BaseViewModel>(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var userID: String
    private var doublePressToExit = false

    override fun getLayoutID(): Int = R.layout.activity_navigator_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = object : BaseViewModel(){}
        userID = intent.getStringExtra("USERID")
        setHeader()
        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun switchFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_fragment,fragment)
            .commitAllowingStateLoss()
    }

    private fun setHeader(){
        drawer_layout.openDrawer(Gravity.START)
        nav_view.getHeaderView(0).tvUsernameHeaderNav?.text = userID
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> logout()
            R.id.item1 -> switchFragment(FragmentTimePicker())
            R.id.item2 -> startActivityDouble()
            R.id.item3 -> Toast.makeText(this,"there are no easter eggs here!!",Toast.LENGTH_SHORT).show()
        }
        drawer_layout.closeDrawer(Gravity.START)
        return true
    }

    private fun startActivityDouble(){
        val intent = Intent(this, ActivityDoubleTheTrouble::class.java)
        startActivity(intent)
    }

    private fun logout(){
        val intent = Intent(this, SplashScreen::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun onBackPressed() {
        if (doublePressToExit) {
            super.onBackPressed()
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            drawer.openDrawer(GravityCompat.START)
        }
        doublePressToExit = true
        Toast.makeText(this, "Press again to exit!", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doublePressToExit = false }, 2000)
    }
}