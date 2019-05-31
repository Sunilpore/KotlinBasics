package com.ktbasiceg.basic2.mykotlin.oops


fun main(arg:Array<String>){

    CustomerData.count = 98
    CustomerData.typeOfCustomers()
    CustomerData.myMethod("hello")

    println(CustomerData.count)



}


class MyCompanionClass{

    companion object {

        var count:Int = -1

        @JvmStatic
        fun typeOfCustomers():String {
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