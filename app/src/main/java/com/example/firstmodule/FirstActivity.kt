package com.example.firstmodule

import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button



class FirstActivity : AppCompatActivity() {
    lateinit var activityManager:ActivityManager
    private val TAG= FirstActivity::class.java.simpleName
    lateinit var button: Button
    lateinit var button2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_first)

        button2=findViewById(R.id.Button2)
        button=findViewById(R.id.Button1)
        button.setOnClickListener{
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            activityManager= getSystemService(ACTIVITY_SERVICE) as ActivityManager

        }

        val serviceInternt= Intent(applicationContext,ServicePractice::class.java)
        button2.setOnClickListener{
            Log.d(TAG,"Thread"+Thread.currentThread().id)
            startService(serviceInternt)
        }
    }

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

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }
}
