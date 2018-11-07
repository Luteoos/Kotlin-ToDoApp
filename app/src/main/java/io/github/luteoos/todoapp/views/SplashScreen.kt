package io.github.luteoos.todoapp.views

import com.luteoos.kotlin.mvvmbaselib.BaseActivityMVVM
import com.luteoos.kotlin.mvvmbaselib.BaseViewModel
import io.github.luteoos.todoapp.R

class SplashScreen : BaseActivityMVVM<BaseViewModel>() {
    override fun getLayoutID(): Int = R.layout.activity_splash_screen
}