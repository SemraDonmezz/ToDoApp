package com.example.todoapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.todoapp.R

fun Navigation.gecisAdd(view:View,id:Int){
    findNavController(view).navigate(R.id.gecisAdd)
}
fun Navigation.gecisDetail(view:View,id:NavDirections){
    findNavController(view).navigate(R.id.gecisAdd)
}