package com.example.firstmodule

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import kotlinx.android.synthetic.main.activity_first.*


class FirstActivity : AppCompatActivity() {
    lateinit var activityManager: ActivityManager

    private val TAG = FirstActivity::class.java.simpleName

    lateinit var servicePractice: ServicePractice
    var isServiceBound: Boolean = false
    var serviceConnection: ServiceConnection? = null

    lateinit var serviceInternt: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_first)
        serviceInternt = Intent(applicationContext, ServicePractice::class.java)
        button1.setOnClickListener {
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager

        }


        button2.setOnClickListener {
            Log.d(TAG, "Thread" + Thread.currentThread().id)
            startService(serviceInternt)
        }
        button3.setOnClickListener {
            stopService(serviceInternt)
        }
        button4.setOnClickListener {
            setRandomNo()
        }
        button5.setOnClickListener {
            bindService()
        }
        button6.setOnClickListener {
            unbindService()
        }
    }

    private fun bindService() {
        if (serviceConnection == null) {
            serviceConnection = object : ServiceConnection {
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    val myServiceBinder =
                        service as ServicePractice.MyServiceBinder
                    servicePractice = myServiceBinder.getService()
                    isServiceBound = true
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    isServiceBound = false
                }
            }
        }

        bindService(serviceInternt, serviceConnection!!, Context.BIND_AUTO_CREATE)


    }

    private fun unbindService() {
        if (isServiceBound) {
            serviceConnection?.let { unbindService(it) }
            isServiceBound = false
        }
    }

    private fun setRandomNo() {

        if (isServiceBound) {
            val temp = "Random number" + servicePractice.getRandomNo()
            textviewService.text = temp
        }
        else {
            val temp="Service unbound"
            textviewService.text = temp
        }
    }


    /*
        protected fun getAppTaskState(): String {

            val stringBuilder = StringBuilder()
            val totalNumberOfTasks =
                activityManager.getRunningTasks(10).size//Returns total number of tasks - stacks
            stringBuilder.append("\nTotal Number of Tasks: $totalNumberOfTasks\n\n")

            val taskInfo =
                activityManager.getRunningTasks(10)//returns List of RunningTaskInfo - corresponding to tasks - stacks

            for (info in taskInfo) {
                stringBuilder.append("Task Id: " + info.id + ", Number of Activities : " + info.numActivities + "\n")//Number of Activities in task - stack

                // Display the root Activity of task-stack
                stringBuilder.append(
                    "TopActivity: " + info.topActivity!!.getClassName().toString().replace(
                        "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                        ""
                    ) + "\n"
                )

                // Display the top Activity of task-stack
                stringBuilder.append(
                    "BaseActivity:" + info.baseActivity!!.getClassName().toString().replace(
                        "lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.",
                        ""
                    ) + "\n"
                )
                stringBuilder.append("\n\n")
            }
            return stringBuilder.toString()
        }

        */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
