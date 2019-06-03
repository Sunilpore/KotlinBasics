package com.ktbasiceg.basic2.mykotlin.collections

/**
 * Created on 3 Jun 2019
 * Here we discuss Muttable and Immutable Set
 */

fun main(){

    //Set contains unique element
    //"HashSet" also contains unique elements but Sequence is not guaranted in o/p

    //Immutable, READ only
    var mySet = setOf<Int>(2,6,32,11,0,2,2,1,1)  //Set nt allow duplicate element

    for(ele in mySet){
    //    println(ele)
    }


    /*------------------------------------*/

    //Muttable Set, READ and WRITE
    var mutableSet = mutableSetOf<Int>(2,6,32,11,0,2,2,1,1)
    var myHashSet = hashSetOf<Int>(2,6,32,11,0,2,2,1,1)

    mutableSet.remove(32)

    for(ele in mutableSet){
        //println(ele)
    }

    for(ele in myHashSet){
        println(ele)
    }


}