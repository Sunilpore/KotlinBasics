package com.ktbasiceg.basic2

import com.ktbasiceg.basic2.model.Person

fun main (args: Array<String>){

    var myNumber = 10;
    var myDecimal  = 10.0

    var myString : String       //Mutable String -> Read and Write
    myString = "Hello world"
    myString = "Hy"

    val otherString :String    //Immutable String -> Read only
    otherString = "Initial commit"

    println(myString)

    var name:String
    name = "Steve"
    display(name)

    //--Access object and method via class
    var person = Person("Cricket")
    person.name = "Captain"
    person.displayName(person.name)
    person.displaySportsName()
}



fun display(name:String){
    println(name)
}


