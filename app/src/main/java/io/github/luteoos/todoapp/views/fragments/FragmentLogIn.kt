package io.github.luteoos.todoapp.views.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.eightbitlab.rxbus.Bus
import com.luteoos.kotlin.mvvmbaselib.BaseFragmentMVVMWithoutVM
import io.github.luteoos.todoapp.R
import io.github.luteoos.todoapp.views.SplashScreen
import io.github.luteoos.todoapp.views.activities.NavigatorMenu
import kotlinx.android.synthetic.main.fragment_log_in.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.ctx

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
        bLogIn.onClick {
            logInValidate()
        }
    }

    private fun logInValidate(){
        if(etEmail.text.toString() == etPassword.text.toString() && etEmail.text.isNotBlank())
            startActivityWithUsername(etEmail.text.toString())
        else
            Toast.makeText(context,"Invalid login or password",Toast.LENGTH_SHORT).show()

    }

    private fun startActivityWithUsername(username: String){
        val intent = Intent(context, NavigatorMenu::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra("USERID",username)
        startActivity(intent)
    }
}