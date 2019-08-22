package com.ktbasiceg.coroutines

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ktbasiceg.R
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.android.synthetic.main.activity_coroutine_network.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class CoroutineNetworkActivity : AppCompatActivity() {

    private val RESULT_1 = "Result_1"
    private val RESULT_2 = "Result_2"
    private val JOB_TIMEOUT = 2900L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_network)


        btn_click2.setOnClickListener {

            CoroutineScope(IO).launch{
                fakeApiRequest()
            }

        }

    }

    private suspend fun fakeApiRequest(){

        withContext(IO){
            /*val job = launch {
                val result1 = getResult1Api()
                println("result #1: ${result1}")
            }*/

            val job = withTimeoutOrNull(JOB_TIMEOUT){
                val result1 = getResult1Api()   //wait
                setTextOnMainThread("Init $result1")

                val result2 = getResult2Api()   //wait
                setTextOnMainThread("Init $result2")
            }

            if(job == null){
                val cancelMsg = "Cancelling job... Job took longer than $JOB_TIMEOUT ms"
                println("debug: $cancelMsg")
                setTextOnMainThread(cancelMsg)
            }

            /*Some extra features
            val job2 = launch {

            }
            job2.join()
            job2.cancel()*/

        }

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


    private suspend fun setTextOnMainThread(input:String){
        withContext(Dispatchers.Main){
            setNewText(input)
        }
    }

    private fun setNewText(input:String) {
        val newText = txt_view2.text.toString()+ " \n $input"
        txt_view2.text = newText
    }


    private fun logThread(methName:String){
        println("debug_kt: ${methName}: ${Thread.currentThread().name}")
    }

}
