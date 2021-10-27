package com.kiniun.covid.uk.app.views.info

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import com.kiniun.covid.uk.app.R
import com.kiniun.covid.uk.app.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before

@RunWith(AndroidJUnit4::class)
@LargeTest
class InformationFragmantTest {

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
    fun informationFragmentTest() {
        onView(withId(R.id.info_btn)).check(matches(withText(R.string.information))).perform(ViewActions.click())

        onView(withId(R.id.info_main_heading)).check(matches(withText(R.string.app_name)))

        onView(withId(R.id.info_content_01)).check(matches(withText(R.string.info_content_01)))

        onView(withId(R.id.info_content_02)).check(matches(withText(R.string.info_content_02)))

        onView(withId(R.id.info_content_03)).check(matches(withText(R.string.info_content_03)))
    }
}