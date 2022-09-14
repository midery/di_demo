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
import com.example.auth_impl.stubs.StubAuthInteractor
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.containsString

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class StubAuthTest {

    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun authorize_stub_user() {
        val stubUserText = "Stub user!"
        StubAuthInteractor.stubUserName = stubUserText

        onView(withText("Next")).perform(click())
        onView(withText(containsString(stubUserText)))
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