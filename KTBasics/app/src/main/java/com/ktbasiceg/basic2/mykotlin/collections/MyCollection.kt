package com.ktbasiceg.basic2.mykotlin.collections

/**
 * Created on 3 Jun 2019
 *
 * Array: Mutable but has Fixed size
 *
 * Collections
 * -> Immutable Collections:READ only operations
 *    Immutable List: listOf
 *    Immutable Map: mapOf
 *    Immutable Set: setOf
 *
 * -> Mutable Collections:READ and WRITE both
 *    Mutable List:ArrayList, arrayListOf, mutableListOf
 *    Mutable Map: HashMap, hashMapOf, mutableMapOf
 *    Mutable Set: mutableSetOf, hashSetOf
 *
 *    Here we discuss Mutable and Immutable List
 */

fun main(arg:Array<String>){

    //Elements:  0  0   0   0   0
    //Index:     0  1   2   3   4

    /**
     *  Array<Type>(size){values/initial value}
     *  myArr -> is Mutable and has fixed size
     */
    var myArr = Array<Int>(5){0}
    myArr[0] = 25
    myArr[3]= 2

    //println(myArr)

    for(ele in myArr){
         //println(ele)
    }

    for(index in 0..myArr.size-1){
       // println(myArr[index])
    }

    /*--------------------------------------*/

    //It is immutable in nature and has fixed size. READ only
    var list = listOf<String>("A","B","C")

    for(index in 0..list.size-1){
        //println(list[index])
      //  println(list.get(index))
    }

    //It is Mutable, No Fixed Size, Can Add or Remove
    var mutableList = mutableListOf<String>("India","US","UK")
    var list2 = arrayListOf<String>("India","US","UK")
    var list3 = ArrayList<String>()

    mutableList.add("SA")
    mutableList.add("Aus")

    for (ele in mutableList){
        println(ele)
    }

    println()
    mutableList.remove("US")
    mutableList.add(1,"SL")
    for (ele in mutableList){
        println(ele)
    }

    println()
    mutableList.add(1,"NZ")
    for (ele in mutableList){
        println(ele)
    }


}