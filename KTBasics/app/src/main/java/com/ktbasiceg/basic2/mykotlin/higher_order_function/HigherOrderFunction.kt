package com.ktbasiceg.basic2.mykotlin.higher_order_function

fun main(arg:Array<String>){

    val result = ArithProgram()

   // result.addTwoNumbers(2,3)

    result.addTwoNumbers(3,5,object :MyInterface{

        override fun executeMeth(sum: Int) {
            println(sum)
        }
    })

    val myLambdaNumber: (Int) -> Unit = {n:Int-> println(n)}   //Lambda Expression [Function]
    result.addTwoNumbers(4,2,myLambdaNumber)
    result.addTwoNumbers(10,20,{x:Int-> println(x)})


}


class ArithProgram {

    fun addTwoNumbers(a:Int, b:Int, action: (Int) -> Unit){        //Higher Level Funcion with Lambda as Function
        val sum =a+b
        action(sum)
    }


    fun addTwoNumbers(a:Int, b:Int, action:MyInterface){           //Using Interface / OOP's concept
        val sum =a+b
        action.executeMeth(sum)
    }

    fun addTwoNumbers(a:Int, b:Int){        //Normal Method call
        var sum =a+b
        println(sum)
    }

}



interface MyInterface {
    fun executeMeth(sum:Int)
}