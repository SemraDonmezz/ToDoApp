package com.example.todoapp.data.repository

import com.example.todoapp.data.datasource.TaskDataSource
import com.example.todoapp.data.entity.TheTasks

class TaskRepository(var dataSourceNesnesi:TaskDataSource) {

    suspend fun add(taskName:String)=dataSourceNesnesi.add(taskName)
    suspend fun update(task_id:Int,task_name:String)=dataSourceNesnesi.update(task_id,task_name)
    suspend fun taskGet():List<TheTasks> = dataSourceNesnesi.taskGet()  // anasayfata veri getirme
    suspend  fun delete(task_id:Int)=dataSourceNesnesi.delete(task_id)
    suspend fun search(searchWord:String):List<TheTasks> = dataSourceNesnesi.search(searchWord)

}