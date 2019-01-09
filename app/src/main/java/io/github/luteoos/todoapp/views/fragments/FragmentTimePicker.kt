package io.github.luteoos.todoapp.views.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.luteoos.kotlin.mvvmbaselib.BaseFragmentMVVMWithoutVM
import io.github.luteoos.todoapp.R
import kotlinx.android.synthetic.main.fragment_time_picker.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class FragmentTimePicker : BaseFragmentMVVMWithoutVM() {
    private var hour: Int = 0
    private var minute: Int = 0

    override fun getLayoutID(): Int = R.layout.fragment_time_picker

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBindings()
    }

    private fun setBindings(){
        ibUpHour.onClick {
            hour++
            validateTime()
        }
        ibUpMinute.onClick {
            minute++
            validateTime()
        }
        ibDownHour.onClick {
            hour--
            validateTime()
        }
        ibDownMinute.onClick {
            minute--
            validateTime()
        }
        tvTimeShow.onClick {
            Toast.makeText(context,"Some day it will start here",Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateTime(){
        if(minute >= 60)
            minute = 0
        if (hour >= 60)
            hour = 0
        if (hour < 0)
            hour = 59
        if(minute < 0)
            minute = 59
        showTime()
    }

    private fun showTime(){
        var timeText = ""
        if (hour<10)
            timeText = "0" + hour.toString()
        else
            timeText = hour.toString()
        timeText +=":"
        if (minute<10)
            timeText += "0" + minute.toString()
        else
            timeText += minute.toString()
        tvTimeShow.text = timeText
    }
}
