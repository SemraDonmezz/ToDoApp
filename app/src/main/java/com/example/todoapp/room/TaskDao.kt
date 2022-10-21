package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.data.entity.TheTasks

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    suspend fun taskGet():List<TheTasks>

    @Insert
    suspend fun add(task: TheTasks)

    @Update
    suspend fun update(task: TheTasks)

    @Delete
    suspend fun delete(task: TheTasks)

    @Query("SELECT * FROM tasks WHERE task_name like '%'|| :searchWord ||'%'")
    suspend fun search(searchWord:String):List<TheTasks>


}