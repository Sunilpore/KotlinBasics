@file:JvmName("MyCustomFileName")

package com.ktbasiceg.basic2.mykotlin

import com.ktbasiceg.basic2.myjava.MyJava
import java.math.BigInteger


fun main(args:Array<String>){

    var largerValue = max(2, 4)
    println(largerValue)

    var maxValue = maxValue(5, 3)
    println(maxValue)

    //Access from method 'getArea()' from Java file
    var area = MyJava.getArea(4, 2)
    println("area is $area")


    //Default functions in Kotlin
    println(" vol1: ${findVolume()} vol2: ${findVolume(2,3)} vol3: ${findVolume(10,20,30)}")

    //Naming parameter
    findVolume2(breadth = 4,heigth = 6, length = 2)


    //Extension Function
    var isPassed = Student().hasPassed(55)
    var isFirstclass = Student().isFirstClass(65)
    println("isPass: $isPassed  isFirstClass: $isFirstclass")

    val str1:String= "World"
    val str2:String= "of Kotlin"

    var str3:String = "Welcome at "
    println(str3.appendAll(str1,str2))



    //Member Function
    Student().hasPassed(56) // create instance of class Student() and call hasPassed()

    //Infix Function  (which is member function or extension function in Kotlin)

    val x:Int = 6
    val y:Int = 12

    val greaterNum = y greaterValue x
    println(" greater no amongst $x and $y is $greaterNum")

    /**
     * Note: All Infix functions are extension function
     *       But all extension functions are not Infix functions
     */

    //TailRec Functions [Recursive Functions]
    println("Fibbonacci no: ${getFibbonacciNumber(10000, BigInteger("1"), BigInteger("0"))}")

}




fun max(a:Int, b:Int): Int{

    if(a>b)
        return a
    else
        return b

}

//One line expression
fun maxValue(a:Int,b:Int): Int = if (a>b) a else b

fun add(a:Int, b:Int):Int{
    return a+b
}

@JvmOverloads
fun findVolume(length:Int = 1, breadth:Int=1, heigth:Int=1): Int{
    return length*breadth*heigth;
}

fun findVolume2(length:Int = 1, breadth:Int=1, heigth:Int=1){

    println("length: "+length)
    println("breadth: "+breadth)
    println("height: "+heigth)
}



/*----Extension Function----*/
//A function which add outside the class but operate as a class property
/*Advantages
* 1. Can add functions to a class without declaring it
* 2. The new function added behaves like static
*
* Few Properties
* 1.They can become part of your own class Eg. Student
* 2. They can become part of predefined classes Eg.String,I nt, Array,etc
*
* Benifits
* 1. Reduces code
* 2.. COde is much cleaner and easy to read
*/

class Student{

    fun hasPassed(marks:Int): Boolean {
        return marks>40                 // implies if(marks>40) true else false
    }

}

fun Student.isFirstClass(marks:Int):Boolean{
    return marks>60;
}

fun String.appendAll(s1:String, s2:String): String{
    return this + s1 + s2
}


/** -----Infix Function-----
 * Infix Function can be a Member Function or Extension Function
 * They have SINGLE Parameter
 * They have prefix of "infix"
 * They have just ONE parameter
 */
infix fun Int.greaterValue(oth:Int):Int{

    if(this>oth)
        return this
    else
        return oth
}

/**
 * So here because of use of 'tailrec' it can exsecute till 10000th element without invoking stackoverflow error
 * stackoverflow error arrises when JVM doesn't left rsources availaible
 */
tailrec fun getFibbonacciNumber(n:Int, a:BigInteger, b:BigInteger): BigInteger{

    if(n == 0)
        return b
    else
        return getFibbonacciNumber(n-1, a+b,a)
}
