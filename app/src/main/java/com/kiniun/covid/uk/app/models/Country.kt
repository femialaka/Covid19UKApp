package com.kiniun.covid.uk.app.models

class Country(val country: CovidDataRegion) {

    val name = name()
    val code = code()

    private fun name(): String {
        return when(country.region) {
            CovidDataRegion.UK.region -> "United Kingdom"
            CovidDataRegion.ENGLAND.region -> "England"
            CovidDataRegion.SCOTLAND.region -> "Scotland"
            CovidDataRegion.WALES.region -> "Wales"
            CovidDataRegion.NI.region -> "Northern Ireland"
            else -> "United Kingdom"
        }
    }

    private fun code(): Int {
        return when(country.region) {
            CovidDataRegion.UK.region -> 0
            CovidDataRegion.ENGLAND.region -> 1
            CovidDataRegion.SCOTLAND.region -> 2
            CovidDataRegion.WALES.region -> 3
            CovidDataRegion.NI.region -> 4
            else -> 5
        }
    }
}