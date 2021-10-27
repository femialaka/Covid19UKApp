package com.kiniun.covid.uk.app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kiniun.covid.uk.app.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import com.kiniun.covid.uk.app.utils.CountryUtil
import org.hamcrest.Matchers.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
@LargeTest
class NavigationTest {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun statup() {
        //Load the application
        onView(withId(R.id.fragmentContainerView))
        onView(withId(R.id.loading_progress))
        Thread.sleep(2000)

        //the data initialization has occured and the honme page is loaded
        onView(withId(R.id.homeFragment))
    }

    @Test
    fun TestNavigationToDisplayUKCovidData() {
        onView(withId(R.id.uk_btn)).check(matches(withText(R.string.uk))).perform(click())
        onView(withId(R.id.displayFragment))
        onView(withId(R.id.sparkview))

        onView(withId(R.id.main_toolbar))
            .check(matches(isDisplayed()))
                .check(matches(withContentDescription(CountryUtil.countries.get(0))))
    }

    @Test
    fun TestNavigationToDisplayEnglandCovidData() {
        onView(withId(R.id.england_btn)).check(matches(withText(R.string.england))).perform(click())
        onView(withId(R.id.displayFragment))
        onView(withId(R.id.sparkview))

        onView(withId(R.id.main_toolbar))
            .check(matches(isDisplayed()))
            .check(matches(withContentDescription(CountryUtil.countries.get(1))))
    }

    @Test
    fun TestNavigationToDisplayScotlandCovidData() {
        onView(withId(R.id.scotland_btn)).check(matches(withText(R.string.scotland))).perform(click())
        onView(withId(R.id.displayFragment))
        onView(withId(R.id.sparkview))

        onView(withId(R.id.main_toolbar))
            .check(matches(isDisplayed()))
            .check(matches(withContentDescription(CountryUtil.countries.get(2))))
    }

    @Test
    fun TestNavigationToDisplayWalesCovidData() {
        onView(withId(R.id.wales_btn)).check(matches(withText(R.string.wales))).perform(click())
        onView(withId(R.id.displayFragment))
        onView(withId(R.id.sparkview))

        onView(withId(R.id.main_toolbar))
            .check(matches(isDisplayed()))
            .check(matches(withContentDescription(CountryUtil.countries.get(3))))
    }

    @Test
    fun TestNavigationToDisplayNICovidData() {
        onView(withId(R.id.ni_btn)).check(matches(withText(R.string.northern_ireland))).perform(click())
        onView(withId(R.id.displayFragment))
        onView(withId(R.id.sparkview))

        onView(withId(R.id.main_toolbar))
            .check(matches(isDisplayed()))
            .check(matches(withContentDescription(CountryUtil.countries.get(4))))
    }



    /* onView(withId(R.id.inf_btn)).check(matches(withText(R.string.information)))
        onView(withId(R.id.help_btn)).check(matches(withText(R.string.help)))*/
}