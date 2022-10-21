package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.TheTasks
import com.example.todoapp.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskMainViewModel @Inject constructor(var taskRepositoryNesnesi:TaskRepository):ViewModel() {

    var taskList=MutableLiveData<List<TheTasks>>()

    init {
        taskGet()
    }
    fun taskGet(){
        CoroutineScope(Dispatchers.Main).launch {
            taskList.value=taskRepositoryNesnesi.taskGet()
        }
    }
    fun delete(task_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            taskRepositoryNesnesi.delete(task_id)
            taskGet() //sayfa guncellemek için gerekli
        }
    }
    fun search(searchWord:String){
        CoroutineScope(Dispatchers.Main).launch {
            taskList.value=taskRepositoryNesnesi.search(searchWord)
        }
    }


}