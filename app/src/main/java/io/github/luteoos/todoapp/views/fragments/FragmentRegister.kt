package io.github.luteoos.todoapp.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.luteoos.kotlin.mvvmbaselib.BaseFragmentMVVMWithoutVM
import io.github.luteoos.todoapp.R
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.fragment_register.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class FragmentRegister : BaseFragmentMVVMWithoutVM() {
    override fun getLayoutID(): Int = R.layout.fragment_register

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBindings()
    }

    private fun setBindings(){
        bCancel.onClick {
            Bus.send("CANCEL_REGISTER")
        }
    }

    companion object {
        fun newInstance(): FragmentRegister {
            val fragment = FragmentRegister()
            return fragment
        }
    }
}