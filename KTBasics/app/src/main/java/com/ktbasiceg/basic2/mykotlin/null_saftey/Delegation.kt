package com.ktbasiceg.basic2.mykotlin.null_saftey

/**
 * Created on 3 Jun 2019
 * Lazy Initialization
 */


val pi: Float by lazy {
    3.14f
}

//Here we can initialize null String
val name:String? by lazy {
    null
}

fun main(){

    println("Initialize the program...")

    val area1 = pi * 4*4      //Here pi is initialized

    val area2 = pi*9*9        //Here pi won't  initialize again it will fetch from cache memory

    println("Some values are...")
    println(name)
}