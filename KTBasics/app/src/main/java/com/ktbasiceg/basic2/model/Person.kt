package com.ktbasiceg.basic2.model

import java.lang.reflect.Constructor

class Person (var sportName:String){

    var name: String = ""

    fun displayName(name:String){
        println(name)
    }

    fun displaySportsName(){
        println("Name of the sports is ${sportName}")
    }
}