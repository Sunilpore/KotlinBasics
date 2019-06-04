package com.ktbasiceg.basic2.mykotlin.delegation



fun main(){

    val jack = Employee(FastCoder(),GoodDesigner() , DangerousTester())
    jack.code()
    jack.design()
    jack.test()
    jack.testFail()
}



internal class Employee(coder: WhoCanCode, designer: WhoCanDesign, tester: WhoCanTest):
    WhoCanCode by coder,WhoCanDesign by designer , WhoCanTest by tester {

}

internal class FastCoder : WhoCanCode {

    override fun code() {
        println("Coded by FastCoder")
    }
}

internal class GoodDesigner : WhoCanDesign {

    override fun design() {
        println("Design by Good Designer")
    }
}

internal class DangerousTester : WhoCanTest {

    override fun testFail() {
        println("Test fail report")
    }

    override fun test() {
        println("Tested by dangerous Tester")
    }
}




internal interface WhoCanCode {
    fun code()
}


internal interface WhoCanDesign {
    fun design()
}

internal interface WhoCanTest {
    fun test()
    fun testFail()
}

