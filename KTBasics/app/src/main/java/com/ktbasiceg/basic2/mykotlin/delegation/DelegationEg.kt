package com.ktbasiceg.basic2.mykotlin.delegation



fun main(){

    val eagle = Eagle(23)
    //eagle.flyAndFindFood()

    var cuckoo = Cuckoo(eagle)
    cuckoo.flyAndFindFood()

}



class Eagle(val age:Int):BirdInterface{

    override fun flyAndFindFood() {
        println("I am Eagle. I am $age years old. I am flying and finding food.")
    }
}

class Cuckoo(b:BirdInterface):BirdInterface by b {

    override fun flyAndFindFood() {
        println("I am cuckoo. I am waiting for a food")
    }

}


interface BirdInterface{
    fun flyAndFindFood()
}