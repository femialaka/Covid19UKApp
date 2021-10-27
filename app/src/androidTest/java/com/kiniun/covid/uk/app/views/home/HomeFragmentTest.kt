package com.kiniun.covid.uk.app.views.display.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import com.kiniun.covid.uk.app.R
import com.kiniun.covid.uk.app.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeFragmentTest {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    private val mIdlingResource: IdlingResource? = null

    @Test
    fun basicHomeFragmentTest() {
        //Load the application
        onView(withId(R.id.fragmentContainerView))
        onView(withId(R.id.loading_progress))
        Thread.sleep(2000)

        //the data initialization has occured and the honme page is loaded
        onView(withId(R.id.homeFragment))

        //With all the options
        onView(withId(R.id.uk_btn)).check(matches(withText(R.string.uk)))
        onView(withId(R.id.england_btn)).check(matches(withText(R.string.england)))
        onView(withId(R.id.scotland_btn)).check(matches(withText(R.string.scotland)))
        onView(withId(R.id.wales_btn)).check(matches(withText(R.string.wales)))
        onView(withId(R.id.ni_btn)).check(matches(withText(R.string.northern_ireland)))
        onView(withId(R.id.info_btn)).check(matches(withText(R.string.information)))
    }

}