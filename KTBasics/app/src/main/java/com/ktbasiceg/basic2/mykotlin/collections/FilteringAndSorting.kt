package com.ktbasiceg.basic2.mykotlin.collections

/**
 * Created on 3 Jun 2019
 * Map amd Filter Fun
 *
 * FILTER
 * Returns a list containing only elements matching the given [predicate]
 *
 *  MAP
 *  Returns a list containing the results of appling the given [transform] function
 *  to each element in the original collection
 *
 */

fun main(){


    val myNumbers: List <Int> = listOf(2,3,5,15,60)

    val smallNo = myNumbers.filter { v-> v<10 }
    val smallNo2 = myNumbers.filter { it<10 }    //As lambda contain single param it can replace with 'it'

    for (num in smallNo2){
       // println(num)
    }


    val mySquareNo = myNumbers.map { it*it }   // { num-> num*num }

    for (squareNo in mySquareNo){
      //  println("square: $squareNo")
    }


    val mySmallSquareNo = myNumbers.filter { it<10 }
                                            .map { it*it }
    for (squareNo in mySmallSquareNo){
        println("square: $squareNo")
    }


    var people = listOf<PersonDetails>(PersonDetails(23,"Ram"),
        PersonDetails(16,"Amit"), PersonDetails
    (20,"Rahul")
    )

    var names = people.filter { it.name.startsWith("A") }  //filter name Start with "A"
                                  .map{it.name}     //Filter name only

    for(name in names){
        println("list name: ${name}")
    }


}

class PersonDetails(var age:Int, var name:String){}