package com.ktbasiceg.basics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ktbasiceg.R

public class BasicTypes : AppCompatActivity() {

    val act_tag = "main_act_tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val asc = Array(5) { i -> (i * i).toString() }
        asc.forEach {
            Log.d(act_tag,"value: "+it)
            println(it) }

        val x: IntArray = intArrayOf(1, 2, 3)
        x[0] = x[1] + x[2]
        Log.d(act_tag,"value: "+x[0])


        /*-------String Literals-------*/
        //Escape String/Conventional String
        val s = "Hello, world!\n"
        Log.d(act_tag,"string_value: "+s)


        //Raw String
        val text = """
            for (c in "foo")
                print(c)
                """
        Log.d(act_tag,"string_value2: "+text)


        val text2 = """
            $s
            |Tell me and I forget.
            |Teach me and I remember.
            |Involve me and I learn.
            (Benjamin Franklin)
            """.trimMargin()
        Log.d(act_tag,"string_value3: "+text2)


        val s2 = "abc"
        Log.d(act_tag,"ss $s2 length is ${s2.length}")

    }

}
