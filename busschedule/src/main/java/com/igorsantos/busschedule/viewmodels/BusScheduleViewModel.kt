package com.igorsantos.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.igorsantos.busschedule.database.schedule.Schedule
import com.igorsantos.busschedule.database.schedule.ScheduleDao
import kotlinx.coroutines.flow.Flow
import java.lang.IllegalArgumentException

class BusScheduleViewModel(
    private val scheduleDao: ScheduleDao
): ViewModel() {

    fun fullSchedule(): Flow<List<Schedule>> = scheduleDao.getAll()

    fun scheduleForStopName(name: String): Flow<List<Schedule>> = scheduleDao.getByStopName(name)

    class BusScheduleViewModelFactory(
        private val scheduleDao: ScheduleDao
    ): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return BusScheduleViewModel(scheduleDao) as T
            }
            throw IllegalArgumentException("Unknow ViewModel class")
        }

    }
}