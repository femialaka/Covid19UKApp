package com.kiniun.covid.uk.app.views.display

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kiniun.covid.uk.app.R
import com.kiniun.covid.uk.app.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.hamcrest.core.StringContains.containsString

@RunWith(AndroidJUnit4::class)
@LargeTest
class DisplayFragmentTest {
    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun TestTheExistenceOfRadioButton() {
        //Load the application
        onView(withId(R.id.fragmentContainerView))
        onView(withId(R.id.loading_progress))
        Thread.sleep(1000)

        //the data initialization has occured and the honme page is loaded
        onView(withId(R.id.homeFragment))

        //With all the options
        onView(withId(R.id.uk_btn)).check(matches(withText(R.string.uk))).perform(click())
        onView(withId(R.id.displayFragment))
        onView(withId(R.id.sparkview))

        onView(withId(R.id.radioButtonAdmissions)).check(matches(withText("Admissions")))
        onView(withId(R.id.radioButtonDeaths)).check(matches(withText("Deaths")))
        onView(withId(R.id.radioButtonCases)).check(matches(withText("Cases")))
    }

    @Test
    fun TestAdmissionsOptionButton() {
        //Load the application
        onView(withId(R.id.fragmentContainerView))
        onView(withId(R.id.loading_progress))
        Thread.sleep(1000)

        //the data initialization has occured and the honme page is loaded
        onView(withId(R.id.homeFragment))

        //With all the options
        onView(withId(R.id.uk_btn)).check(matches(withText(R.string.uk))).perform(click())
        onView(withId(R.id.displayFragment))
        onView(withId(R.id.sparkview))

        onView(withId(R.id.radioButtonAdmissions)).check(matches(withText("Admissions")))
        onView(withId(R.id.scrub_info_textview)).check(matches(withText(containsString("cases"))))
    }

    @Test
    fun TestDeathsOptionButton() {
        //Load the application
        onView(withId(R.id.fragmentContainerView))
        onView(withId(R.id.loading_progress))
        Thread.sleep(1000)

        //the data initialization has occured and the honme page is loaded
        onView(withId(R.id.homeFragment))

        //With all the options
        onView(withId(R.id.uk_btn)).check(matches(withText(R.string.uk))).perform(click())
        onView(withId(R.id.displayFragment))
        onView(withId(R.id.sparkview))

        onView(withId(R.id.radioButtonDeaths)).check(matches(withText("Deaths"))).perform(click())
        onView(withId(R.id.scrub_info_textview)).check(matches(withText(containsString("deaths"))))
    }

    @Test
    fun TestCasesOptionButton() {
        //Load the application
        onView(withId(R.id.fragmentContainerView))
        onView(withId(R.id.loading_progress))
        Thread.sleep(1000)

        //the data initialization has occured and the honme page is loaded
        onView(withId(R.id.homeFragment))

        //With all the options
        onView(withId(R.id.uk_btn)).check(matches(withText(R.string.uk))).perform(click())
        onView(withId(R.id.displayFragment))
        onView(withId(R.id.sparkview))

        onView(withId(R.id.radioButtonCases)).check(matches(withText("Cases"))).perform(click())
        onView(withId(R.id.scrub_info_textview)).check(matches(withText(containsString("cases"))))
    }
}