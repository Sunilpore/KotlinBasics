package com.ktbasiceg.basics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.ktbasiceg.LogHelper
import com.ktbasiceg.R
import java.lang.Exception

class Idioms : AppCompatActivity() {

    val act_tag = "log_data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meth1("Sam",23)
        Log.d(act_tag,meth1("aqua"))


        val map = mapOf("a" to 1, "b" to 2, "c" to 3)  //("key" to value)
        Log.d(act_tag,"map_value: "+map["a"])


        val result = try{
            transform("Red")
        } catch (e: Exception){
            e.message
        }
        Log.d(act_tag,"color: "+result)


        val result2 = try{
            transform("White")
        }catch (e: Exception){
            "Enter valid color Name..."
            //e.message
        }

        Log.d(act_tag,"color: "+result2)

        Log.d(act_tag,"foo: "+foo(1))

        Log.d(act_tag,"arrayOfMinusOnes: "+ Gson().toJson(arrayOfMinusOnes(1)) )

        //Swap two variables
        var a = 1
        var b = 2
        a = b.also { b = a }
        LogHelper().showLog("swap a: "+a+" \t b: "+b)

    }




    fun meth1(name: String,age: Int): Unit{
        Log.d(act_tag,"Name: "+name+" \tage: "+age)
    }


    fun meth1(name: String): String{
        if(name.equals("aqua")){
            return "Atlantis"
        }
        return "Other"
    }

    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }


    fun foo(param: Int): String {
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
        return result;
    }


    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(5) }
    }


}