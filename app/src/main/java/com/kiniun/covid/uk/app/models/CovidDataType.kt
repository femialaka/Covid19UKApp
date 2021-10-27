package com.kiniun.covid.uk.app.models

enum class CovidDataType(val dataType: String) {
    NEWCASSES("New cases"), ADMISSIONS("Hospital Admissions"), DEATH("New deaths")
}