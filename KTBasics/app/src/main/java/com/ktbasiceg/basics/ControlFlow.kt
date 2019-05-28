package com.ktbasiceg.basics

fun main(args:Array<String>){

    // Traditional usage
    var a = 10
    var b=20

    var max: Int = a
    if (a < b) max = b
    println("max: "+max)


    // With else
    var mx: Int
    if (a > b) {
        mx = a
    } else {
        mx = b
    }

    println("max2: "+mx)

    // As expression
    val maximum = if (a > b) a else b


}

