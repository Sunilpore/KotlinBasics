package com.ktbasiceg.basics


fun main(args:Array<String>){

    val demo = Outer.Nested().foo() // == 2
    println(demo)

    val demo2 = Outer().NestedInner().foo2() // == 1
    println(demo2)


}



class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }

    inner class NestedInner{
        fun foo2() = bar
    }
}

