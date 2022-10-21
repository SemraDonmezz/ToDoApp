package com.example.todoapp.data.datasource

import android.util.Log
import android.view.View
import androidx.navigation.Navigation
import com.example.todoapp.R
import com.example.todoapp.data.entity.TheTasks
import com.example.todoapp.room.TaskDao
import com.example.todoapp.utils.gecisAdd
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDataSource(var tdao:TaskDao) {
    suspend fun add(taskName:String){
        val newTask=TheTasks(0,taskName)
        tdao.add(newTask)
        //Log.e("Task is added","$taskName")
    }
    suspend fun update(task_id:Int,task_name:String){
        val updateTask=TheTasks(task_id,task_name)
        tdao.update(updateTask)
        //Log.e("The Task is Updated","$task_id-$task_name")
    }
    suspend fun fabTikla(view: View){
        Navigation.gecisAdd(view,R.id.gecisAdd)
    }
    suspend  fun delete(task_id:Int){
        val deleteTask=TheTasks(task_id,"")
        tdao.delete(deleteTask)
    }

    suspend fun taskGet():List<TheTasks> =
        withContext(Dispatchers.IO) {
            tdao.taskGet()  //veritabanından verileri alıyoruz
        }

    suspend fun search(searchWord:String):List<TheTasks> =
        withContext(Dispatchers.IO) {
           tdao.search(searchWord)
        }
}