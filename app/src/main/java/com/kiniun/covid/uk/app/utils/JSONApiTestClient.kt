package com.kiniun.covid.uk.app.utils

import com.kiniun.covid.uk.app.data.source.remote.ApiClient
import com.kiniun.covid.uk.app.models.CovidData
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class JSONApiTestClient: ApiClient {
    override fun getUKCovidData() = Observable.empty<CovidData>().single(CovidTestDataUtil.covidDataGenerator())

    override fun getEnglandCovidData() = Observable.empty<CovidData>().single(CovidTestDataUtil.covidDataGenerator())

    override fun getScotlandCovidData() = Observable.empty<CovidData>().single(CovidTestDataUtil.covidDataGenerator())

    override fun getWalesCovidData() = Observable.empty<CovidData>().single(CovidTestDataUtil.covidDataGenerator())

    override fun getNICovidData() = Observable.empty<CovidData>().single(CovidTestDataUtil.covidDataGenerator())
}
