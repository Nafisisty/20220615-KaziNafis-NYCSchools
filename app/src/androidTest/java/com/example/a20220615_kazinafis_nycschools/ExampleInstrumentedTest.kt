package com.example.a20220615_kazinafis_nycschools

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.a20220615_kazinafis_nycschools.view.activities.MainActivity
import org.hamcrest.Matchers.allOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.lang.Thread.sleep

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun scroll_to_item() {

        sleep(5000)

        val textView = onView(
            allOf(withId(R.id.school_name), withText("Brooklyn School for Music & Theatre"),
            withParent(withParent(withId(R.id.schools_recyclerView))),
            isDisplayed())
        )
        textView.check(matches(withText("Brooklyn School for Music & Theatre")))
    }
}