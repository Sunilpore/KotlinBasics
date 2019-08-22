package com.ktbasiceg.coroutines

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.ktbasiceg.R
import kotlinx.android.synthetic.main.activity_coroutine3.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class CoroutineActivity3 : AppCompatActivity() {

    private val PROGRESS_MAX = 100
    private val PROGRESS_START = 0
    private val JOB_TIME = 4000 //ms
    private lateinit var job: CompletableJob

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine3)

        job_button.setOnClickListener {
            if(!::job.isInitialized){
                initJob()
            }
            job_progress_bar.startJobOrCancel(job)
        }

    }

    fun ProgressBar.startJobOrCancel(job: Job){
        if(this.progress > 0){
            println("${job} is already active.  Cancelling...")
            resetJob()
        } else {
            job_button.setText("Cancel job #1")

            /*// It will cancel all the coroutine/jobs run in background
            val scope =  CoroutineScope(IO).launch {}
            scope.cancel() */

            //To avoid this problem
            val scope =  CoroutineScope(IO + job).launch {
                println("coroutine ${this} is activated with job ${job}")

                for(i in PROGRESS_START.. PROGRESS_MAX){
                    kotlinx.coroutines.delay((JOB_TIME / PROGRESS_MAX).toLong())
                    this@startJobOrCancel.progress = i
                }
                updateJobCompleteTextView("Job is complete")
            }


           /* //It will create a new coroutine context, independent of any other coroutine context
            CoroutineScope(IO + job).launch {}
            CoroutineScope(IO + job2).launch {}
            //job2 is totally independent of job. So if you cancel job then it will not interere with job2
            */

        }
    }

    private fun updateJobCompleteTextView(text: String){
        GlobalScope.launch(Main) {
            job_complete_tv.setText(text)
        }
    }

    private fun resetJob(){
        if(job.isActive || job.isCompleted){
            //Here we can customize our message which we want to show like timeout, no connection, or any other Toast message
            job.cancel(CancellationException("Resetting job"))   //It will throw an exception which caught by job.invokeOnCompletion inside initJob() method
        }

        //Here we call initJob(). Because once job is cancelled it will never reuse again in future.
        initJob()
    }

    fun initJob(){
        job_button.setText("Start Job #1")
        updateJobCompleteTextView("")
        job_complete_tv.setText("")
        job = Job()

        job.invokeOnCompletion {
            it?.message.let {
                var msg = it
                if(msg.isNullOrBlank()){
                    msg = "Unknown cancellation error"
                }
                println("${job} was cancelled. Error: $msg")
                showToast(msg)
            }
        }
        job_progress_bar.max = PROGRESS_MAX
        job_progress_bar.progress = PROGRESS_START
    }


    fun showToast(text:String){
        GlobalScope.launch(Main) {
            Toast.makeText(this@CoroutineActivity3,text,Toast.LENGTH_SHORT).show()
        }

    }

}
