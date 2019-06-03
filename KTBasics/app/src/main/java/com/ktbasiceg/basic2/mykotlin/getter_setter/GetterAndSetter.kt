package com.ktbasiceg.basic2.mykotlin.getter_setter


fun main(){

    var person = Individual("Jack",23)


    println(person.name)
    person.age = 28
}

class Individual(_name: String, _age: Int){


    var name:String = _name
        get() = field
        set(value) {
            field = value
        }


    var age:Int = _age
        get() = field
        set(value) {
            field = value
        }


}