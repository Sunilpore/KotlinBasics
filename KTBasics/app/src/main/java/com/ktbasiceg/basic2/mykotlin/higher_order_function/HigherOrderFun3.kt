package com.ktbasiceg.basic2.mykotlin.higher_order_function

/**
 * "it":Implicit name of Single Parameter
 */

fun main(arg:Array<String>){

    val program = ArithProgram2()
    //program.reverseAndDisplay("hello",{s-> s.reversed()})

    //here it replace s->s. So 'it' can be applicable where there is single parameter is exist
    //program.reverseAndDisplay("hello",{it.reversed()})

    var person = PersonLambda()


    //with keyword
    with(person){
        name = "Jay"
        age = 31
    }
    println(person.name)
    println(person.age)

    /**
     * Here apply return's a reciever.
     * At here reciever is 'person'
     * In case of 'apply()' we can call method after initializing vairiable.
     * But in case of 'with()' method call is not applicable
     */
    person.apply {
        name = "Atul"
        age = 35
    }.startRun()

    println(person.name)
    println(person.age)

}

class ArithProgram2 {

    fun reverseAndDisplay(str: String, myFun: (String)->String){

        var res = myFun(str)       //   it.reversed() / str.reversed() ==> 'hello' = "olleh"
        println(res)
    }
}


class PersonLambda{

    var name: String = ""
    var age: Int = -1

    fun startRun(){
        println("Now I am ready to run")
    }

}
