package com.androiddevs.runningappyt

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RunDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run:Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsShortedByTimeInMillis():LiveData<List<Run>>
    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsShortedByCaloriesBurned():LiveData<List<Run>>
    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    fun getAllRunsShortedByAvgSpeed():LiveData<List<Run>>
    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunsShortedByDistance():LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis():LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned():LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistanceInMeters():LiveData<Int>
    @Query("SELECT AVG(avgSpeedInKMH) FROM running_table")
    fun getTotalAvgSpeedInKMH():LiveData<Float>
}