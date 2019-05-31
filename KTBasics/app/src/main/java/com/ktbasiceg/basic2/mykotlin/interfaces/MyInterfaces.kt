package com.ktbasiceg.basic2.mykotlin.interfaces


fun main(arg:Array<String>){

    var myEvent = Event()
    //myEvent.onTouch()
    //myEvent.onClick()

    val myEventCall = EventCall()
    myEventCall.onTouch()
    myEventCall.onClick()

}
/**
 * Normal methods are public and open by default, NOT FINAL
 * You can not create instance/objects of interface
 */


interface MyINterfaceListener {

    var name:String

    fun onTouch()

    fun onClick(){
        println("Button was click")
    }
}


interface MySecondInterface {

    fun onTouch(){
        println("Second Interface: ontouch")
    }

    fun onClick(){
        println("Second Interface: onlick")
    }
}



class Event: MyINterfaceListener {

    override var name: String = ""

    //This is has to compuslory override
    override fun onTouch() {
        println("On touch is call")
        }

    //This is not compulsory method
    override fun onClick() {
        super.onClick()
        println("On click is call")
    }

}


class EventCall :MyINterfaceListener, MySecondInterface {

    override var name: String =""

    override fun onClick() {
        super<MySecondInterface>.onClick()           //To avoid ambugity between same method
        super<MySecondInterface>.onClick()
    }

    override fun onTouch() {
        super.onTouch()
        }

}