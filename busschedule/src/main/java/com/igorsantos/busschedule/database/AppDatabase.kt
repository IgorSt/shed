package com.igorsantos.busschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.igorsantos.busschedule.database.schedule.Schedule
import com.igorsantos.busschedule.database.schedule.ScheduleDao

@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun scheduleDao(): ScheduleDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}