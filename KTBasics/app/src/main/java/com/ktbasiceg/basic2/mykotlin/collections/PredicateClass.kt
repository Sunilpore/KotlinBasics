package com.ktbasiceg.basic2.mykotlin.collections

/**
 * Created on 3 Jun 2019
 * Here we see about Predicate Operator
 * Predicate just return true/false
 */

fun main(){

    val myNumbers = listOf(2,3,50,63)

    var myPredicate = {num:Int->num>10}  //Here we cannot use 'it' as it doesn't have list refrence here as below it have as 'myNumbers'

    val ch1 = myNumbers.all { it >10 }        //Are all elements greater than 10?
    val ch2 = myNumbers.all ( { it >10 } )
    val chp2 = myNumbers.all ( myPredicate )
    println(chp2)

    val ch3 = myNumbers.any( { it>10 } )      //DOes any of these elements satisfy the Predicate?
    val chp3 = myNumbers.any(myPredicate )
    println("check 3 : $chp3")

    val totalCount = myNumbers.count( { it>10 } )  //Number of elements that satisfy the Predicate
    val totalCountp = myNumbers.count( myPredicate )
    println("total count: "+totalCount)

    val firstNo = myNumbers.find { it>10 }        //Returns the first number that matches the Predicate
    val firstNop2 = myNumbers.find (myPredicate)
    println("first no: "+firstNo)


}