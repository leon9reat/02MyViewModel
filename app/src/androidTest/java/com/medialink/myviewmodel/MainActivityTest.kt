package com.medialink.myviewmodel

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private val dummyWidth = "1"
    private val dummyLength = "2"
    private val dummyHeight = "3"
    private val dummyResult = "6"

    @Before
    fun SetUp() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun prosesBenar() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).perform(click())
        onView(withId(R.id.tv_result)).check(matches(withText(dummyResult)))
    }

    @Test
    fun prosesLengthKosong() {
        onView(withId(R.id.edt_length)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).perform(click())
        onView(withId(R.id.edt_length)).check(matches(hasErrorText("Panjang tidak boleh kosong")))
    }

    //onView(withId(R.id.tv_result)).check(matches(withText(dummyResult)))
    @Test
    fun prosesWidthKosong() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).perform(click())
        onView(withId(R.id.edt_width)).check(matches(hasErrorText("Lebar tidak boleh kosong")))
    }

    @Test
    fun prosesHeightKosong() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(""), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).perform(click())
        onView(withId(R.id.edt_height)).check(matches(hasErrorText("Tinggi tidak boleh kosong")))

    }

    @Test
    fun prosesPecahan() {
        onView(withId(R.id.edt_length)).perform(typeText("1.5"), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(""), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).perform(click())
    }


}

