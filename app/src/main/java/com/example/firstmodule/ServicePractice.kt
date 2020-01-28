package com.example.firstmodule

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
private val TAG= ServicePractice::class.java.simpleName
class ServicePractice: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"Thread"+Thread.currentThread().id)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"OnDestroy")
        stopSelf()
    }
}