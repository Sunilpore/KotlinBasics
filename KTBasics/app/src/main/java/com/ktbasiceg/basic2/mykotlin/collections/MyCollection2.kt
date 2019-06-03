package com.ktbasiceg.basic2.mykotlin.collections

import android.os.Build

/**
 * Created on 3 Jun 2019
 * Here we discuss Muttable and Immutable HashMap
 */



fun main(arg:Array<String>){

    // (key,value) can be Int,String,Char

    //Immutable and has fixed size
    var myMap = mapOf<Int,String>(4 to  "Sam", 23 to "KK", 11 to "JJ")


    for(key in myMap.keys){
        //println("Element at Keys: $key = ${myMap.get(key)}")
        //println("Element at Keys: $key = ${myMap[key]}")
    }


    //Mutable, READ and WRITE both,No Fixed Size
    var mutableMap = HashMap<Int,String>()
    var mutableMap2 = mutableMapOf<Int,String>()   //LinkedHashMap
    var mutableMap3 = hashMapOf<Int,String>()


    mutableMap.put(8,"Motrola")
    mutableMap.put(3,"Real me")
    mutableMap.put(2,"Redmi")

    for(key in mutableMap.keys){
        println("Element at key: $key = ${mutableMap[key]}")
    }


    mutableMap.replace(8,"AZUS")


    for(key in mutableMap.keys){
        println("Element at key: $key = ${mutableMap[key]}")
    }

}