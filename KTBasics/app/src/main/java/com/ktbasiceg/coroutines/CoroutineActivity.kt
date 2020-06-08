package com.ktbasiceg.coroutines

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ktbasiceg.R
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineActivity : AppCompatActivity() {

    private val RESULT_1 = "Result_1"
    private val RESULT_2 = "Result_2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        btn_click.setOnClickListener {

            //Types of coroutine scope IO, Main, Default
            /*
              @IO -> used for Network and local db operation interaction
              @Main() -> doing some operation on main thread i.e. interacting with UI
              @Default -> used for heavy computational work like filter, sort, etc.
             */

            CoroutineScope(IO).launch {
                fakeApiRequest()
            }

        }

    }

    private suspend fun fakeApiRequest(){

        //It will create worker Thread1
        val result = getResult1Api()
        println("debug_kt: $result")
        setTextOnMainThread(result)

        //It will create worker Thread2
        val result2 = getResult2Api()
        println("debug_kt: $result2")
        setTextOnMainThread(result2)

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

        //When we .launch{} coroutine it will launch new coroutine and when we use withContext() it will not fire new coroutine
        // instead

       /* CoroutineScope(Main).launch{
            setNewText(input)
        }*/

        //It can switch a context of coroutine and allow to do action on main thread.
        withContext(Main){
            setNewText(input)
        }
    }

    private fun setNewText(input:String) {
        val newText = txt_view.text.toString()+ " \n $input"
        txt_view.text = newText
    }


    private fun logThread(methName:String){
        println("debug_kt: ${methName}: ${Thread.currentThread().name}")
    }

}

/*
    Coroutines are jobs need to be done and Thread is a place where Job is done.

    There are possibility that one thread consist of multiple coroutines

    Coroutine is thread independent.
    Means, you can start coroutine from one thread and pass it to another thread do some work and again pass it to another thread

    Coroutine Scope/Coroutine Context:-
    Grouping a bunch of jobs together.
    So if you want to execute Job1...5 and on suddenly on Job 3 it fails , so you cancel all of the coroutines within that scope.
    So it is way to group them together , So that if one fail you can cancel them all
 */