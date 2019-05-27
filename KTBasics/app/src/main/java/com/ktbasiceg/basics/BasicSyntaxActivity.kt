package com.ktbasiceg.basics;

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ktbasiceg.R

public class BasicSyntaxActivity : AppCompatActivity() {

    val act_tag = "main_act_tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //--Using string templates
        var a = 1
        // simple name in template:
        val s1 = "a is $a"

        a = 2
        // arbitrary expression in template:
        val s2 = "${s1.replace("is", "will")}, but now is $a"
        Log.d(act_tag,"replace_fun: "+s2)


        //--Using nullable values and checking for null
        Log.d(act_tag,"str_length: "+getStringLength(""))

        //--Using conditional expressions
        Log.d(act_tag,"max_value: "+maxOfOld(30,12))
        Log.d(act_tag,"max_value: "+maxOf(22,40))


        //--Using a for loop
        val items = listOf("apple", "banana", "kiwifruit")
        for (item in items) {
            Log.d(act_tag,"loop_value: "+item)
        }

        when {
            "apple" in items-> Log.d(act_tag,"apple_is_exist")
        }

        for (index in items.indices) {
            Log.d(act_tag,"item at $index is ${items[index]}")
        }

        //--Using when expression
        Log.d(act_tag,describe(1))
        Log.d(act_tag,describe("Hello"))
        Log.d(act_tag,describe(1000L))
        Log.d(act_tag,describe("other"))

        //--Using ranges
        val x = 10
        val y = 9
        if (x in 2..y+1) {
            Log.d(act_tag,"fits in range")
        }else {
            Log.d(act_tag,"out of range")
        }

        for (x in 1..5) {
            Log.d(act_tag,"range_trial :"+x)
        }

        for (x in 1..10 step 2) {
            Log.d(act_tag,"range_step_up: "+x)
        }

        for (x in 9 downTo 0 step 3) {
            Log.d(act_tag,"range_step_down:"+x)
        }

        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits.filter {it.startsWith("a")}
            .sortedBy{it}
            .map { it.toUpperCase() }
            .forEach{Log.d(act_tag,"map_collection: "+it)}


        //--Creating basic classes and their instances
        val rectangle = Rectangle(5.0, 2.0) //no 'new' keyword required
        val triangle = Triangle(3.0, 4.0, 5.0)
        Log.d(act_tag,"Area of rectangle is ${rectangle.calculateArea()}, its perimeter is ${rectangle.perimeter}")
        Log.d(act_tag,"Area of triangle is ${triangle.calculateArea()}, its perimeter is ${triangle.perimeter}")

    }



    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // `obj` is automatically cast to `String` in this branch
            return obj.length
        }
        // `obj` is still of type `Any` outside of the type-checked branch
        return null
    }


    fun maxOfOld(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }


    fun maxOf(a: Int, b: Int) = if (a > b) a else b

    fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
            else       -> "Unknown"
    }




    abstract class Shape(val sides: List<Double>) {
        val perimeter: Double get() = sides.sum()
        abstract fun calculateArea(): Double
    }

    interface RectangleProperties {
        val isSquare: Boolean
    }

    class Rectangle(
    var height: Double,
    var length: Double
    ) : Shape(listOf(height, length, height, length)), RectangleProperties {
        override val isSquare: Boolean get() = length == height
        override fun calculateArea(): Double = height * length
    }

    class Triangle(
    var sideA: Double,
    var sideB: Double,
    var sideC: Double
    ) : Shape(listOf(sideA, sideB, sideC)) {
        override fun calculateArea(): Double {
            val s = perimeter / 2
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
        }
    }


}
