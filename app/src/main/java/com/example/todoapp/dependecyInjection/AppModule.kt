package com.example.todoapp.dependecyInjection

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.todoapp.data.datasource.TaskDataSource
import com.example.todoapp.data.repository.TaskRepository
import com.example.todoapp.room.TaskDao
import com.example.todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTaskRepository(tds: TaskDataSource):TaskRepository{
        return TaskRepository(tds)
    }
    @Provides
    @Singleton
    fun provideTaskDataSource(tdao:TaskDao):TaskDataSource{
        return TaskDataSource(tdao)
    }
    @Provides
    @Singleton
    fun provideTaskDao(@ApplicationContext context: Context):TaskDao{
        val datab=Room.databaseBuilder(context,Veritabani::class.java,"toDoApp.sqlite")
            .createFromAsset("toDoApp.sqlite").build()
        return datab.getTaskDao()
    }

}