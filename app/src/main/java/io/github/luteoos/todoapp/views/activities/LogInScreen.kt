package io.github.luteoos.todoapp.views.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.eightbitlab.rxbus.Bus
import com.luteoos.kotlin.mvvmbaselib.BaseActivityMVVM
import com.luteoos.kotlin.mvvmbaselib.BaseFragmentMVVMWithoutVM
import com.luteoos.kotlin.mvvmbaselib.BaseViewModel
import io.github.luteoos.todoapp.R
import io.github.luteoos.todoapp.views.fragments.FragmentLogIn
import io.github.luteoos.todoapp.views.fragments.FragmentRegister
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.fragment_register.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class LogInScreen : BaseActivityMVVM<BaseViewModel>() {
    override fun getLayoutID(): Int = R.layout.activity_log_in

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = object : BaseViewModel(){}

        setBindings()
        initLogInFragment()

    }

    private fun setBindings(){
        Bus.observe<String>()
            .subscribe(){
                when(it){
                    "CANCEL_REGISTER" -> {
                        replaceFragment(FragmentLogIn())
                    }
                    "OPEN_REGISTER" -> {
                            replaceFragment(FragmentRegister())
                    }
                }
            }
    }

    private fun initLogInFragment(){
        replaceFragment(FragmentLogIn())
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragment,fragment)
            //.addToBackStack(null) let us onbackpressed comes back through fragemnts
            .commit()
    }
}