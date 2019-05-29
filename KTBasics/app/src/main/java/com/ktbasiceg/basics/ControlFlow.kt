package com.ktbasiceg.basics

import java.lang.Integer.parseInt

fun main(args:Array<String>){

    // Traditional usage
    var a = 10
    var b=20

    var max: Int = a
    if (a < b) max = b
    println("max: "+max)


    // With else
    var mx: Int
    if (a > b) {
        mx = a
    } else {
        mx = b
    }

    println("max2: "+mx)

    // As expression
    a=50
    b=10
    val maximum = if (a > b) a else b
    println("max3: "+maximum)


    //If you're using if as an expression rather than a statement
    // (for example, returning its value or assigning it to a variable), the expression is required to have an else branch.
    //In multiple line of if blocl last line will return a value to expression by default
    var max4:Int = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }


    println("max4: "+max4)


    //when expression intead of switch operator
    var x=1
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        2 -> print("x == 2")
        in 1..5-> println("x value lies in between 1 to 5")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }


    println("Types: ${hasPrefix("hello")}  ${hasPrefix(2)}   ${hasPrefix(false)}")


    val array = arrayOf("a", "b", "c")
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }


    returnFun1()
    reurnFun2()
    returnFun3()

}



fun hasPrefix(x: Any): Any = when(x) {
    is String -> "String"
    is Int -> 1
    is Boolean -> true
    else -> false
}


fun returnFun1(){
    //Break and return to outer function in case here it returns to returnFun1() function
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // local return to the caller of the lambda, i.e. the forEach loop without executing below code and execute next condition of loop
        print(it)
    }
}

fun reurnFun2(){
    println()
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop without executing below code and execute next condition of loop
        print(it)
    }
}

fun returnFun3(){
    println()
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda, i.e. the forEach loop
        print(it)
    }
}

