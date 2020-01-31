package com.example.firstmodule.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Student::class],//, College::class, //Parent::class]
    version = 1
)
abstract class StudentDatabase: RoomDatabase() {
    abstract  fun getStudentDao():StudentDao
    companion object{
        @Volatile private var instance: StudentDatabase ? = null      //Volatile beacause the instance should be immediately available to componenets

        private val Lock=Any()
        operator fun invoke(context:Context)= instance ?: synchronized(Lock)
        {
            instance ?: buildDatabase(context).also{
                instance = it
            }
        }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            StudentDatabase::class.java,
            "studentdatabase"
        ).build()
    }



}