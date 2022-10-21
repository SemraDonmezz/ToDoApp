package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTaskDetailBinding
import com.example.todoapp.ui.viewmodel.TaskAddViewModel
import com.example.todoapp.ui.viewmodel.TaskDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskDetailFragment : Fragment() {
    private lateinit var tasarim:FragmentTaskDetailBinding
    private lateinit var viewModel: TaskDetailViewModel
   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_task_detail, container, false)
       tasarim.taskDetailFragment=this

       tasarim.taskDetailToolbarTitle="Yapılacak İş Detay"

       val bundle:TaskDetailFragmentArgs by navArgs()
       val gelenTask=bundle.theTask
       tasarim.editTextTaskName.setText(gelenTask.task_name)

       tasarim.taskNesnesi=gelenTask

        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TaskDetailViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun btnUpdate(task_id:Int,task_name:String){
        viewModel.update(task_id,task_name)
    }
}