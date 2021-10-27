package com.kiniun.covid.uk.app.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UKCovidDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(covidRecordEntityList: List<CovidRecordEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(covidRecord: CovidRecordEntity)

    @Query("DELETE FROM covid_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM covid_table WHERE countryCode = :countryCode")
    fun getAll(countryCode: Int) : LiveData<List<CovidRecordEntity>>
}
