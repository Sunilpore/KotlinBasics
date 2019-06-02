package com.ktbasiceg.basic2.mykotlin.higher_order_function


fun main(arg:Array<String>){

    val program = ArithProg()
    val myLambda : (Int,Int) -> Int = {x:Int, y:Int -> x+y}

 //   program.addTwoNumbers(5,6,myLambda)

    program.addTwoNumbers(1,1,{x,y -> x+y } )

    program.addTwoNumbers(4,4) {x,y -> x+y }

    /**
     * In Java 8, you cannot mutate/change values of outside variable from inside of Lambdas
     * But in Kotlin you can change the values called as closures
     */
    var result = 0
    program.addTwoNumbersClosure(4,4) {x,y -> result = x+y }
    println("result: $result")
}






class ArithProg {

    fun addTwoNumbers(a:Int, b:Int, action: (Int,Int) -> Int){        //Higher Level Funcion with Lambda as Function

        println(action(a,b))      // x + y -> result i.e. 5 + 6 -> (return) 11
    }


    fun addTwoNumbersClosure(a:Int, b:Int, action: (Int,Int) -> Unit){        //Higher Level Funcion with Lambda as Function

        action(a,b)      // x + y -> result i.e. 5 + 6 -> (return) 11
    }


}
