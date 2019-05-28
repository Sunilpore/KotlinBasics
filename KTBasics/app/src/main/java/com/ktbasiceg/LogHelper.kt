package com.ktbasiceg

import android.util.Log

public class LogHelper{

    val TAG_DATA = "log_data"

    fun showLog(msg:String){
        Log.d(TAG_DATA,msg)
    }

}