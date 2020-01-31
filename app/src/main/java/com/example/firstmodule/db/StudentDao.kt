package com.example.firstmodule.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    fun addStudent(student:Student)

    @Query("SELECT * FROM student")
    fun getAllStudents() : List<Student>
}