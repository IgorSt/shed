package com.igorsantos.busschedule

import android.app.Application
import com.igorsantos.busschedule.database.AppDatabase

class BusScheduleApplication: Application() {

    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}