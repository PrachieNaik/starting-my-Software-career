package com.example.firstmodule

import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class FirstActivity : AppCompatActivity() {
    lateinit var activityManager:ActivityManager

    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        button=findViewById(R.id.Button1)
        button.setOnClickListener{
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            activityManager= getSystemService(ACTIVITY_SERVICE) as ActivityManager
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
}
