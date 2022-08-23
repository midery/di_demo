package com.example.di_demo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.Visibility.VISIBLE
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.auth_api.AuthDependencies
import com.example.component.findDependency
import com.example.di_demo.feature.StubAuthInteractor
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.containsString

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun authorize_stub_user() {
        onView(withText("Next")).perform(click())

        onView(withText(containsString("Stub user!")))
            .check(matches(withEffectiveVisibility(VISIBLE)))
    }

    @Test
    fun authInteractor_isFake() {
        val authInteractor =
            InstrumentationRegistry.getInstrumentation().targetContext
                .findDependency<AuthDependencies>()
                .authInteractor()
        assertThat(authInteractor, `is`(StubAuthInteractor))

    }
}