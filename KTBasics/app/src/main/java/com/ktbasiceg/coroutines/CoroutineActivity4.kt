package com.ktbasiceg.coroutines

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ktbasiceg.R
import kotlinx.android.synthetic.main.activity_coroutine4.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.system.measureTimeMillis

class CoroutineActivity4 : AppCompatActivity() {

    private val RESULT_1 = "Result_1"
    private val RESULT_2 = "Result_2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine4)

        btn_click.setOnClickListener {
            setNewText("Clicked!")

            //with normal job launch
            //fakeApiRequest()

            //with async-awit. Here we get result value to access outside the Coroutine
            // i.e in normal way we get result1 value inside launch{} but with async we can able to dervice result1 outside the async launch
            fakeApiAsyncRequest()
        }

    }

    private fun fakeApiAsyncRequest() {
        CoroutineScope(IO).launch {

            val executionTime = measureTimeMillis {
                val result1: Deferred<String> = async {
                    logThread("debug_kt: launching job1")
                    getResult1Api()
                }

                val result2: Deferred<String> = async {
                    logThread("debug_kt: launching job2")
                    getResult2Api()
                }

                setTextOnMainThread("Got ${result1.await()}")
                setTextOnMainThread("Got ${result2.await()}")
            }

            println("debug_kt: Total time elapsed: ${executionTime}")
        }


        val startTime = System.currentTimeMillis()
        val parenJob = CoroutineScope(IO).launch {
            val job1 = launch {
                val time1 = measureTimeMillis {
                    logThread("launching job1 in thread: ")
                    val result1 = getResult1Api()
                    setTextOnMainThread("Got $result1")
                }
                println("debug_kt: completed job1 in $time1 ms.")
            }

            val job2 = launch {
                val time2 = measureTimeMillis {
                    logThread("launching job1 in thread: ")
                    val result2 = getResult2Api()
                    setTextOnMainThread("Got $result2")
                }
                println("debug_kt: completed job1 in $time2 ms.")
            }

        }

        parenJob.invokeOnCompletion {
            println("debug_kt: Total elapsed time: ${System.currentTimeMillis() - startTime}")
        }
    }

    private fun fakeApiRequest() {
        val startTime = System.currentTimeMillis()
        val parenJob = CoroutineScope(IO).launch {
            val job1 = launch {
                val time1 = measureTimeMillis {
                    logThread("launching job1 in thread: ")
                    val result1 = getResult1Api()
                    setTextOnMainThread("Got $result1")
                }
                println("debug_kt: completed job1 in $time1 ms.")
            }

            val job2 = launch {
                val time2 = measureTimeMillis {
                    logThread("launching job1 in thread: ")
                    val result2 = getResult2Api()
                    setTextOnMainThread("Got $result2")
                }
                println("debug_kt: completed job1 in $time2 ms.")
            }

        }

        parenJob.invokeOnCompletion {
            println("debug_kt: Total elapsed time: ${System.currentTimeMillis() - startTime}")
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

    private suspend fun getResult2Api(): String{
        logThread("getResult2FromApi")
        delay(1000)
        return RESULT_2
    }

    private fun logThread(methName:String){
        println("debug_kt: ${methName}: ${Thread.currentThread().name}")
    }
}
