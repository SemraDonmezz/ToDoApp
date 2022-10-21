package com.example.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.entity.TheTasks
import com.example.todoapp.databinding.CardDesignBinding
import com.example.todoapp.databinding.FragmentTaskAddBinding
import com.example.todoapp.ui.fragment.TaskMainFragment
import com.example.todoapp.ui.fragment.TaskMainFragmentDirections
import com.example.todoapp.ui.viewmodel.TaskMainViewModel
import com.example.todoapp.utils.gecisAdd
import com.example.todoapp.utils.gecisDetail
import com.google.android.material.snackbar.Snackbar

class TaskAdapter(var mContext:Context, var taskList: List<TheTasks>,var viewModel:TaskMainViewModel)
    :RecyclerView.Adapter<TaskAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:CardDesignBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardDesignBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       val tasarim:CardDesignBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_design,parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val task=taskList.get(position)
        val t=holder.tasarim
        t.taskNesnesi=task

        t.imageDelete.setOnClickListener {
            Snackbar.make(it,"${task.task_name} will delete",Snackbar.LENGTH_LONG)
                .setAction("Yes"){
                    viewModel.delete(task.task_id)
            }.show()

        }
        t.textViewTask.setOnClickListener {
            val gecis=TaskMainFragmentDirections.gecisDetail(theTask=task)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}