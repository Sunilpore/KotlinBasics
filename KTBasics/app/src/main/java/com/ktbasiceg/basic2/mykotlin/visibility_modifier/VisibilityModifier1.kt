package com.ktbasiceg.basic2.mykotlin.visibility_modifier


private fun run(){}


class Test {

    //person.a , person.b are not visible
    //person.c , person.d are visible

    fun testing(){

        var person = Person()
        println(person.d)

    }
}


open class Person {     //Super class

    private val a = 1
    protected  val b = 2  //only visible into the sub class not into the other some class
    internal val c = 3    // visible only within same module
    val d = 10

}


class SportsMan: Person(){      //Derived Class or Subclass

    //a is not visible
    //b,c,d are visible

}