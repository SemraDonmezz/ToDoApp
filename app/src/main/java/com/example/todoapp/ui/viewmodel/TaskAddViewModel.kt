package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskAddViewModel @Inject constructor(var taskRepositoryNesnesi:TaskRepository):ViewModel() {

    fun add(taskName:String){
        CoroutineScope(Dispatchers.Main).launch {
            taskRepositoryNesnesi.add(taskName)
        }
    }

}