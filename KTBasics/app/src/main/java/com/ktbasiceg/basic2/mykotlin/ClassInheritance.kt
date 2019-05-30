package com.ktbasiceg.basic2.mykotlin


fun main(arg:Array<String>){

    var dog = Dog()
    dog.breed = "lambra"
    println(dog.color)
    dog.color = "black"
    //dog.bark()
    dog.eat()
    println(dog.color)


    var cat = Cat()
    cat.age = 2
    cat.color = "brown"
    //cat.meow()
    cat.eat()

    var animal = Animal()
    animal.color = "white"
    animal.eat()

}

//You have to make Parent class open to inherit its property to child class
//In kotlin all classes and its fields are public and final bydefault
open class Animal{

    open var color:String = ""
    open fun eat(){
        println("Animal is Eating")
    }
}


//Method overriding means redifing and modifying Base class method inside the derived/child class
  class Dog : Animal() {

    var breed:String = ""
    override var color:String = "Grey"

    fun bark(){
        println("bark")}


    override fun eat(){
        super<Animal>.eat()       //If we have Interface ITest which also override same method eat().So it create ambugity during run time.
                                  //To avoid it we write super<Animal>.eat() instead of super.eat()
        println("Dog is Eating")
    }

}

class Cat :Animal() {

    var age:Int = -1
    fun meow(){
        println("Meow")
    }

    override fun eat(){
        println("Cat is Eating")
    }

}