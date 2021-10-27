package com.kiniun.covid.uk.app.data.source.repositories

import androidx.lifecycle.LiveData
import com.kiniun.covid.uk.app.data.source.local.CovidRecordEntity
import com.kiniun.covid.uk.app.data.source.local.UKCovidDao
import javax.inject.Inject

class UKCovidDataRepository @Inject constructor(val dataSource: UKCovidDao): CovidDataRepository {

    override suspend fun insert(covidRecordList: List<CovidRecordEntity>) {
        dataSource.insert(covidRecordList)
    }

    override suspend fun insert(covidRecord: CovidRecordEntity) {
        dataSource.insert(covidRecord)
    }

    override suspend fun deleteAll() {
        dataSource.deleteAll()
    }
    override fun getAll(countryCode: Int) : LiveData<List<CovidRecordEntity>> {
        return dataSource.getAll(countryCode)
    }
}
