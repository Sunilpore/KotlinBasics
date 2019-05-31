package com.ktbasiceg.basic2.mykotlin.abstract_prop


/**
 * All abstract are open by default
 * All normal function: public and final by default
 * The ROLE of ABSTRACT class is to just provide set of methods and properties
 * Abstract class are partially defined class it doesn't have its own code
 * You can not create instance/objects of ABSTRACT class
*/
fun main(arg:Array<String>){


}


//abstract method and property are just defind but not initialized it
abstract class Person {

    abstract var name:String

    abstract fun eat ()     //abstract properties are "open" by default

    open fun getHeight(){}

}



class NormalPerson : Person() {

        override var name:String = "dummy_name"

        override fun eat() {

        }

        override fun getHeight(){

    }
}