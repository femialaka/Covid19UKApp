package com.kiniun.covid.uk.app.main

import com.kiniun.covid.uk.app.data.source.local.CovidRecordEntity
import com.kiniun.covid.uk.app.models.CovidDataType
import com.robinhood.spark.SparkAdapter

class CovidInfoAdapter(private var covidData: List<CovidRecordEntity>, private var dataType: CovidDataType): SparkAdapter() {

    fun resetData(newCovidData: List<CovidRecordEntity>, newDataType: CovidDataType) {
        covidData = newCovidData
        dataType = newDataType
    }
    override fun getCount() = covidData.size
    override fun getItem(index: Int) = covidData[index]

    override fun getY(index: Int) =
        when(dataType) {
            CovidDataType.NEWCASSES -> covidData[index].newCases.toFloat()
            CovidDataType.DEATH -> covidData[index].newDeaths.toFloat()
            CovidDataType.ADMISSIONS -> covidData[index].newAdmissions.toFloat()
        }
}