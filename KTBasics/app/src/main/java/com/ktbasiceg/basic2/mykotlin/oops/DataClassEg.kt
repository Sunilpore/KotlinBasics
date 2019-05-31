package com.ktbasiceg.basic2.mykotlin.oops

fun main(arg:Array<String>){

    var user1 = User("ABC",1)
    var user2 = User("ABC",1)

    println(user1)

    if(user1 == user2)
        println("Equal")
    else
        println("Not Equal")

    var newUser = user1


    //see the 'copy()' function in documentation
}

//When you want to compare data then use 'data' keyword infront of class
 class User(var name:String, var id:Int){

}