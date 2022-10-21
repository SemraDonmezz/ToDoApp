package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.TheTasks
import com.example.todoapp.databinding.FragmentTaskDetailBinding
import com.example.todoapp.databinding.FragmentTaskMainBinding
import com.example.todoapp.ui.adapter.TaskAdapter
import com.example.todoapp.ui.viewmodel.TaskDetailViewModel
import com.example.todoapp.ui.viewmodel.TaskMainViewModel
import com.example.todoapp.utils.gecisAdd
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskMainFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentTaskMainBinding
    private lateinit var viewModel: TaskMainViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_task_main, container, false)
        tasarim.taskMainFragment=this

        tasarim.taskMainToolbarTitle="Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarMain)

        //verileri anasayfaya yukle
        viewModel.taskList.observe(viewLifecycleOwner){
            val adapter=TaskAdapter(requireContext(),it,viewModel)
            tasarim.taskAdapter=adapter
        }

        requireActivity().addMenuProvider(object:MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                 menuInflater.inflate(R.menu.search_menu,menu)

                val searchView=menu.findItem(R.id.searchAction).actionView as SearchView
                searchView.setOnQueryTextListener(this@TaskMainFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                 return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TaskMainViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.taskGet()
    }

    fun fabTikla(view:View){
       Navigation.gecisAdd(view,R.id.gecisAdd)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
         return true
    }

}