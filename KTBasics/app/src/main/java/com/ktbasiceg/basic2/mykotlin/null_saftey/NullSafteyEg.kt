package com.ktbasiceg.basic2.mykotlin.null_saftey

/**
 *  Created on 3 Jun 2019
 *  ? => Safe call operator
 *  ?: => Elvis
 *  !! => Not-null Assertion
 *  ?.let{..} => Safe Call with le
 */

fun main(){

    val name:String? = null
    println(name)

    /**
     * 1. Safe CAll (?.)
     * Return the length if 'name' is not null else returns NULL
     * Use it if you don't mind getting NULL value
     */
      println("The length of name is ${name?.length}")


    /**
     * 2. Safe Call with let (?/let)
     * It execute the block inside let {..block..} only if name is NOT NULL
     */
      name?.let{ println("The length of name is ${name.length}") }


    /**
     * 3. Elvis-operator
     * When we have nullable refrence 'name', we can say "is name is not null", use it,
     * otherwise use some non-null value
     */

    //Convetional way
    val len = if(name!=null)
                        name.length
                    else
                        -1
    //It is same as above conventional way or like ternary operator
    val length = name?.length?:-1
    println("The length of name is $length")


    /**
     * 4. Non-null assertion  operator (!!)
     * Use it when yu are sure the value is NOT NULL
     */
      println("The length of name is ${name!!.length}")

    //Collection of Nullable type
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()

}