package com.ktbasiceg.basic2.mykotlin

import android.os.Parcel
import android.os.Parcelable

fun main(arg:Array<String>){

    var student = Sport("Football",10)
    println(student.id)
}



class Sport (var name:String) {

    var id:Int = -1

    init {
            println("Sport name is ${name} and no. of teams are $id")
    }

    //Here declaring parameter in secondary constructor is not allow
    constructor(secName: String, id: Int): this(secName){
        //The body of the Secondary constructor is called after the init block
        this.id = id
    }

}