package com.kiniun.covid.uk.app.data.source.repositories

import androidx.lifecycle.LiveData
import com.kiniun.covid.uk.app.data.source.local.CovidRecordEntity
import com.kiniun.covid.uk.app.models.CovidDataRegion

interface CovidDataRepository {
    suspend fun insert(covidRecordList: List<CovidRecordEntity>)
    suspend fun insert(covidRecord: CovidRecordEntity)
    suspend fun deleteAll()
    fun getAll(countryCode: Int): LiveData<List<CovidRecordEntity>>
}