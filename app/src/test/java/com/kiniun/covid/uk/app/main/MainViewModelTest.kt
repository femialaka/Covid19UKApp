package com.kiniun.covid.uk.app.main

import android.os.Looper.getMainLooper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kiniun.covid.uk.app.CovidAppUKApplication
import com.kiniun.covid.uk.app.data.source.remote.EmptyApiTestClient
import com.kiniun.covid.uk.app.data.source.remote.ErrorApiTestClient
import com.kiniun.covid.uk.app.utils.JSONApiTestClient
import com.kiniun.covid.uk.app.util.getOrAwaitValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows.shadowOf

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    lateinit var mainViewModel: MainViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val app = ApplicationProvider.getApplicationContext() as CovidAppUKApplication
        mainViewModel = MainViewModel(app.repository)
    }

    @Test
    fun `when loading api data loading should be true and error should be false`() {
        val testApi = JSONApiTestClient().getUKCovidData()
        mainViewModel.initApp(testApi, 0, false)

        assertThat(mainViewModel.loading.getOrAwaitValue(), `is`(true))
        assertThat(mainViewModel.error.getOrAwaitValue(), `is`(false))
    }

    @Test
    fun `when loading bad api data loading should be false and error should be true`() {
        val errorTestApi = ErrorApiTestClient().getUKCovidData()
        mainViewModel.initApp(errorTestApi, 0,false)
        //shadowOf(getMainLooper()).idle()

        assertThat(mainViewModel.loading.getOrAwaitValue(), `is`(false))
        assertThat(mainViewModel.error.getOrAwaitValue(), `is`(true))
    }

    @Test
    fun `when loading empty api data loading should be true and error should be false`() {
        val emptyTestApi = EmptyApiTestClient().getUKCovidData()
        mainViewModel.initApp(emptyTestApi, 0, false)

        assertThat(mainViewModel.loading.getOrAwaitValue(), `is`(true))
        assertThat(mainViewModel.error.getOrAwaitValue(), `is`(false))
    }

    @Test
    fun `load Covid Api data test`() {
        val testApi = JSONApiTestClient().getUKCovidData()
        mainViewModel.initApp(testApi, 0, false)

        shadowOf(getMainLooper()).idle()

        assertThat(mainViewModel.data.getOrAwaitValue().maxPageLimit, `is`(30))
        assertThat(mainViewModel.data.getOrAwaitValue().length, `is`(40))
        assertThat(mainViewModel.data.getOrAwaitValue().data!!.size, `is`(40))
    }

}