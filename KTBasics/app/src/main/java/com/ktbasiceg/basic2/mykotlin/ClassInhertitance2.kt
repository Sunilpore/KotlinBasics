package com.ktbasiceg.basic2.mykotlin

import java.util.zip.CRC32

fun main(arg:Array<String>){

    //Primary and Secondary constructor
    var game = Cricket("cricket","outdoor")
}


open class Game {

    var gName:String=""
    constructor(name:String) {
        this.gName = name
        println("Name of the game is $name")
    }
    /*init {
        println("Name of the game is $name")
    }*/
}


class Cricket: Game {

    var type:String = ""
    constructor(name:String, type: String):super(name){
        this.type = name
        println("$name is $type game")
    }
    /*init {
        println("$name is $type game")
    }*/

}
