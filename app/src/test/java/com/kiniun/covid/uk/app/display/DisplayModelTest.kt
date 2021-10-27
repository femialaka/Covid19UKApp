package com.kiniun.covid.uk.app.display

import android.graphics.Color
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kiniun.covid.uk.app.CovidAppUKApplication
import com.kiniun.covid.uk.app.models.CovidDataType
import com.kiniun.covid.uk.app.views.display.DisplayViewModel
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DisplayModelTest {
    lateinit var viewModel: DisplayViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val app = ApplicationProvider.getApplicationContext() as CovidAppUKApplication
        viewModel = DisplayViewModel(app.repository)
    }

    @Test
    fun testCountryCodes() {
        viewModel.setCountryCode(0)
        val uk = viewModel.getCountry()
        viewModel.setCountryCode(1)
        val england = viewModel.getCountry()
        viewModel.setCountryCode(2)
        val scotland = viewModel.getCountry()
        viewModel.setCountryCode(3)
        val wales = viewModel.getCountry()
        viewModel.setCountryCode(4)
        val ni = viewModel.getCountry()

        assertThat(uk, Matchers.`is`("UK "))
        assertThat(england, Matchers.`is`("England "))
        assertThat(scotland, Matchers.`is`("Scotland "))
        assertThat(wales, Matchers.`is`("Wales "))
        assertThat(ni, Matchers.`is`("Northern Ireland "))
    }

    @Test
    fun testColorMap() {
       val color1 = viewModel.colorMap.getValue(CovidDataType.NEWCASSES.dataType)
       val color2 = viewModel.colorMap.getValue(CovidDataType.ADMISSIONS.dataType)
       val color3 = viewModel.colorMap.getValue(CovidDataType.DEATH.dataType)

        assertThat(color1, Matchers.`is`(Color.parseColor("#4CAF50").toInt()))
        assertThat(color2, Matchers.`is`(Color.parseColor("#FF9800").toInt()))
        assertThat(color3, Matchers.`is`(Color.parseColor("#FF5722").toInt()))
    }

}