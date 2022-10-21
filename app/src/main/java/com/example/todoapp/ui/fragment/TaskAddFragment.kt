package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.todoapp.R
import com.example.todoapp.databinding.CardDesignBinding
import com.example.todoapp.databinding.FragmentTaskAddBinding
import com.example.todoapp.ui.viewmodel.TaskAddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskAddFragment : Fragment() {
    private lateinit var tasarim:FragmentTaskAddBinding
    private lateinit var viewModel: TaskAddViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_task_add, container, false)
        tasarim.taskAddFragment=this

        tasarim.taskAddToolbarTitle="Yapılacak İş Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:TaskAddViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun btnAdd(taskName:String){
        viewModel.add(taskName)
    }
}