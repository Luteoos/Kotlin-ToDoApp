package io.github.luteoos.todoapp.views.fragments

import android.os.Bundle
import android.view.View
import com.eightbitlab.rxbus.Bus
import com.luteoos.kotlin.mvvmbaselib.BaseFragmentMVVMWithoutVM
import io.github.luteoos.todoapp.R
import kotlinx.android.synthetic.main.fragment_log_in.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class FragmentLogIn : BaseFragmentMVVMWithoutVM() {
    override fun getLayoutID(): Int = R.layout.fragment_log_in

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBindings()
    }

    private fun setBindings(){
        bRegister.onClick {
            Bus.send("OPEN_REGISTER")
        }
    }
}