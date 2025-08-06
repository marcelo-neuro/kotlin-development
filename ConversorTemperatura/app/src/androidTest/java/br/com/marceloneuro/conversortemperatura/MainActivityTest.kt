package br.com.marceloneuro.conversortemperatura

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setUpt() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testCelsius2FahrenheitConversaoSucesso() {
        onView(withId(R.id.etTemperature))
            .perform(typeText("25"))
        onView(withId(R.id.rbCelsius))
            .perform(click())
        onView(withId(R.id.btnConvert))
            .perform(click())
        onView(withId(R.id.tvResult)).check(matches(withText("77.0")))
    }

}