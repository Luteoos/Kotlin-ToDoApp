package io.github.luteoos.todoapp.views

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.luteoos.kotlin.mvvmbaselib.BaseActivityMVVM
import com.luteoos.kotlin.mvvmbaselib.BaseViewModel
import io.github.luteoos.todoapp.R
import io.github.luteoos.todoapp.views.activities.LogInScreen
import kotlinx.android.synthetic.main.activity_splash_screen.*
import org.jetbrains.anko.activityManager
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.ctx
import org.jetbrains.anko.sdk27.coroutines.onClick
import timber.log.Timber
import java.util.*

class SplashScreen : BaseActivityMVVM<BaseViewModel>() {
    override fun getLayoutID(): Int = R.layout.activity_splash_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = object : BaseViewModel(){}
        setBindings()
        setAnimations()
//       supportFragmentManager.beginTransaction().replace().commit()
    }

    private fun setAnimations(){
        cl.let {
            it.background = getDrawable(R.color.md_amber_100)

        }
    }
    private fun setBindings(){
       tvTitle.onClick {
           startLogInScreen()
       }
        cl.onClick {
            cl.apply {
                val rng = Random()
                backgroundColor = Color.argb(255, rng.nextInt(256),rng.nextInt(256),rng.nextInt(256))
            }
        }
    }

    private fun startLogInScreen(){
        val intent = Intent(this,LogInScreen::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}