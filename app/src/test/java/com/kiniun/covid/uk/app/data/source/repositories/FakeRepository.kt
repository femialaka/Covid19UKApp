package com.kiniun.covid.uk.app.data.source.repositories

import androidx.lifecycle.MutableLiveData
import com.kiniun.covid.uk.app.data.source.local.CovidRecordEntity

class FakeRepository(val dataSource: FakeDataSource) : CovidDataRepository {

    override fun getAll(countryCode: Int) = dataSource.getAll()

    override suspend fun insert(covidRecordList: List<CovidRecordEntity>) {
        dataSource.insert(covidRecordList)
    }

    override suspend fun insert(covidRecord: CovidRecordEntity) {
        dataSource.insert(covidRecord)
    }

    override suspend fun deleteAll() = dataSource.deleteAll()
}

class FakeDataSource(val dataSource: ArrayList<CovidRecordEntity>) {

    fun getAll() = MutableLiveData(dataSource.toList())

    suspend fun insert(covidRecordList: List<CovidRecordEntity>) {
        dataSource.addAll(covidRecordList)
    }

    suspend fun insert(covidRecord: CovidRecordEntity) {
        dataSource.add(covidRecord)
    }

    suspend fun deleteAll() = dataSource.clear()
}
