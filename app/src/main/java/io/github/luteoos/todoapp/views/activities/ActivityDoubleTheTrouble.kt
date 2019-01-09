package io.github.luteoos.todoapp.views.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import com.luteoos.kotlin.mvvmbaselib.BaseActivityMVVM
import com.luteoos.kotlin.mvvmbaselib.BaseViewModel
import io.github.luteoos.todoapp.R
import io.github.luteoos.todoapp.views.fragments.FragmentLogIn
import io.github.luteoos.todoapp.views.fragments.FragmentTimePicker
import kotlinx.android.synthetic.main.fragment_double_trouble.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ActivityDoubleTheTrouble : BaseActivityMVVM<BaseViewModel>() {

    override fun getLayoutID(): Int = R.layout.fragment_double_trouble

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = object: BaseViewModel(){}
        setBindings()
    }

    private fun setBindings(){
        btnUpFragment.onClick {
            addFragment(FragmentTimePicker(),0)
        }
        btnDownFragment.onClick {
            addFragment(FragmentLogIn(),1)
        }
    }

    private fun addFragment(fragment: Fragment,i: Int){
        when(i){
            0 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentUp, fragment)
                    .commitAllowingStateLoss()
            }
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentDown, fragment)
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
        }
    }
}