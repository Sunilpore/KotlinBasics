package com.ktbasiceg.basic2.mykotlin.oops

/**
 *  Companion Objects are same as 'object' but declared within a class
 */

fun main(arg:Array<String>){

    CustomerData.count = 98
    CustomerData.typeOfCustomers()
    CustomerData.myMethod("hello")

    println(CustomerData.count)



}

//when we define companion object inside the class all the fields and methods inside companion object behave as a STATIC

class MyCompanionClass{

    companion object {

        var count:Int = -1          // behave like a STATIC variable

        @JvmStatic
        fun typeOfCustomers():String {  //behave like a STATIC method
            return "Regular"
        }

    }



}


open class MySuperClass {

    open fun myMethod(str: String){
        println("MySuperClass")
    }

}


object CustomerData : MySuperClass() {

    var count:Int = -1        //Behave as a static variable

    init {
        //initialize here...
    }

    fun typeOfCustomers():String{
        return "regular"
    }

    override fun myMethod(str: String) {
        super.myMethod(str)
        println("Customer data: $str")
    }

}