package com.example.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.entity.TheTasks

@Database(entities = [TheTasks::class], version = 1)
abstract class Veritabani:RoomDatabase() {
    abstract fun getTaskDao():TaskDao

}