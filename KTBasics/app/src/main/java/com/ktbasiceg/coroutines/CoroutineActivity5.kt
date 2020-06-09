package com.ktbasiceg.coroutines

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ktbasiceg.R
import kotlinx.android.synthetic.main.activity_coroutine4.*
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.system.measureTimeMillis

class CoroutineActivity5 : AppCompatActivity() {

    private val RESULT_1 = "Result_1"
    private val RESULT_2 = "Result_2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine5)

        btn_click.setOnClickListener {
            setNewText("Clicked!")

            fakeApiRequest()
        }

    }

    private fun fakeApiRequest() {

        CoroutineScope(Dispatchers.IO).launch {
                val executionTime = measureTimeMillis {

                    val result1 = async {
                        logThread("launching job1 in thread: ")
                        getResult1Api()
                    }.await()

                    var result2=""
                    try {

                        result2 = async{
                            logThread("launching job2 in thread: ")
                            getResult2Api("adadas")
                        }.await()

                        println("debug_kt: got result2 ${result2}")
                    }   catch (e:Exception){
                        println("debug_kt: got result2 exception ${e.message}")
                    }
                    setTextOnMainThread("Got $result1 :: $result2")
                }
                println("debug_kt: completed job1 in $executionTime ms.")

        }


    }

    private suspend fun setTextOnMainThread(input:String){

        //It can switch a context of coroutine and allow to do action on main thread.
        withContext(Dispatchers.Main){
            setNewText(input)
        }
    }

    private fun setNewText(input:String) {
        val newText = txt_view.text.toString()+ " \n $input"
        txt_view.text = newText
    }

    private suspend fun getResult1Api(): String{
        logThread("getResult1FromApi")
        delay(1000)      // It only delay the single coroutine not a entire Thread
        //Thread.sleep(1000)  //Here it will sleep entire thread for that milisec
        return RESULT_1
    }

    private suspend fun getResult2Api(result:String): String{
        logThread("getResult2FromApi")
        delay(1000)
        if(result.equals(RESULT_1)){
            return RESULT_2
        }
        //return "ERROR..."
        throw CancellationException("Result #1 was incorrect...")
    }

    private fun logThread(methName:String){
        println("debug_kt: ${methName}: ${Thread.currentThread().name}")
    }

}
