package com.ktbasiceg.basic2

fun main (args:Array<String>){

    //Every variable in kotlin treat as a object

    var name:String
    name = "Kotlin"

    var age: Int =10
    var myAge = 20

    var isALive: Boolean =true
    var marks: Float = 97.4F
    var percentage: Double = 85.36
    var gender: Char = 'R'


    //--String interpolation
    var newName = "Wayne"
    var str = "Hello ${newName}"
    print("Total characters: ${str.length}")

}