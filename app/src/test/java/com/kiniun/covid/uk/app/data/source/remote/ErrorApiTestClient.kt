package com.kiniun.covid.uk.app.data.source.remote

import com.kiniun.covid.uk.app.models.CovidData
import io.reactivex.rxjava3.core.Single

class ErrorApiTestClient: ApiClient {
    override fun getUKCovidData() = Single.error<CovidData>(Throwable())
    override fun getEnglandCovidData() = Single.error<CovidData>(Throwable())

    override fun getScotlandCovidData() = Single.error<CovidData>(Throwable())

    override fun getWalesCovidData() = Single.error<CovidData>(Throwable())

    override fun getNICovidData() = Single.error<CovidData>(Throwable())
}