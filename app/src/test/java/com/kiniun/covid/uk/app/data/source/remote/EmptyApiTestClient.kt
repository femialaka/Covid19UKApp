package com.kiniun.covid.uk.app.data.source.remote

import com.kiniun.covid.uk.app.models.CovidData
import io.reactivex.rxjava3.core.Observable

class EmptyApiTestClient: ApiClient {
   val emptyCovidData = CovidData(emptyList(), 0, 0)

   override fun getUKCovidData() = Observable.empty<CovidData>().single(emptyCovidData)

   override fun getEnglandCovidData() = Observable.empty<CovidData>().single(emptyCovidData)

   override fun getScotlandCovidData() = Observable.empty<CovidData>().single(emptyCovidData)

   override fun getWalesCovidData() = Observable.empty<CovidData>().single(emptyCovidData)

   override fun getNICovidData() = Observable.empty<CovidData>().single(emptyCovidData)
}
