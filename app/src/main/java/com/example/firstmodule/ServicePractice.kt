package com.example.firstmodule

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlin.properties.Delegates
import kotlin.random.Random

private val TAG= ServicePractice::class.java.simpleName
class ServicePractice: Service() {


    private var MAX=100
    private var MIN=0
    var randomNumber =0
    var isRandomGeneratorOn:Boolean=false

     inner class MyServiceBinder : Binder() {
        fun getService(): ServicePractice {
            return this@ServicePractice
        }
    }
    val mBinder:IBinder=MyServiceBinder()
    override fun onBind(intent: Intent?): IBinder? {

        return mBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"Thread"+Thread.currentThread().id)
        isRandomGeneratorOn=true
        Thread(Runnable{ startRandomNumberGenerator()}).start()

        return START_STICKY
    }
    fun startRandomNumberGenerator()
    {
        while(isRandomGeneratorOn)
        {
            Thread.sleep(1000)
            if(isRandomGeneratorOn)
            {
                randomNumber= Random.nextInt(MAX)+MIN
                Log.d(TAG,"Thread id "+Thread.currentThread().id+"Random Number "+randomNumber)

            }
        }
    }
    fun stopRandomNumberGenerator()
    {
        isRandomGeneratorOn=false
    }
    fun getRandomNo():Int
    {
        return randomNumber
    }
    override fun onDestroy() {
        super.onDestroy()
        stopRandomNumberGenerator()
        Log.d(TAG,"OnDestroy")
        //stopSelf()
    }
}