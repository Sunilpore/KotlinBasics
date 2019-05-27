package com.ktbasiceg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    val act_tag = "main_act_tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meth1("Sam",23)
        Log.d(act_tag,meth1("aqua"))


        val map = mapOf("a" to 1, "b" to 2, "c" to 3)  //("key" to value)
        Log.d(act_tag,"map_value: "+map["a"])


        val result = try{
            transform("Red")
        } catch (e:Exception){
            e.message
        }
        Log.d(act_tag,"color: "+result)


       val result2 = try{
           Log.d(act_tag,"color: "+transform("White"))
        }catch (e:Exception){
           "Enter valid color Name..."
           //e.message
        }

        Log.d(act_tag,"color: "+result2)

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




}
