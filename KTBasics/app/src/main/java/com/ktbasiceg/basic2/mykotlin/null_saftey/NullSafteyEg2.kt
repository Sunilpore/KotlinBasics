package com.ktbasiceg.basic2.mykotlin.null_saftey

/**
 * Created on 3 Jun 2019
 *
 * Here we discuss Lateinit,
 * lateinit used only with mutable data type [var]
 * lateinit used only with non-nullable data types
 * lateinit values must be initialised before you use it
 */

fun main(){

    val country = Country()
    //country.name = "India"
    //println(country.name)

    country.setUp()
}


class Country {

    lateinit var name:String

    fun setUp(){
        name = "USA"
        println("The name of the country is $name")
    }

}