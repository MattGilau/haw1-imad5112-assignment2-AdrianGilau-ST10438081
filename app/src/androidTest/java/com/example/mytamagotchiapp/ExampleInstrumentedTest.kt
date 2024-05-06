package com.example.mytamagotchiapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Test to verify whether the the application context has the correct package name
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.mytamagotchiapp", appContext.packageName)
    }
    @Before // This method is run before each test method "@Test" and launches the MainActivity
    fun setUp() {                                                                                   //(OpenAI, 2024)
        // Launch the MainActivity before each test to setup initial state
        ActivityScenario.launch(MainActivity::class.java)
    }
    @Test // This test method checks whether the screen transition behavior is functioning correct
    fun testScreenTransition() {                                                                    //(OpenAI, 2024)
        // Click on the Start button
        onView(withId(R.id.btnStart)).perform(click())

        // Check if MainActivityTamagotchi is displayed
        onView(withId(R.id.virtualPet)).check(matches(isDisplayed()))
    }
    @Test // Test method to check if the feed button functions and increases the hunger status value
    fun testFeedButton() {                                                                          //(OpenAI, 2024)
        // Click on the Start button
        onView(withId(R.id.btnStart)).perform(click())

        // Click on the Feed button
        onView(withId(R.id.feedBtn)).perform(click())

        // Check if hunger value increased
        onView(withId(R.id.hungerTxt)).check(matches(withText("100")))
    }

    @Test // Test method to check if the clean button functions and increases the cleanliness status value
    fun testCleanButton() {                                                                         //(OpenAI, 2024)
        // Click on the Start button
        onView(withId(R.id.btnStart)).perform(click())

        // Click on the Clean button
        onView(withId(R.id.cleanBtn)).perform(click())

        // Check if cleanliness value increased
        onView(withId(R.id.cleanTxt)).check(matches(withText("100")))
    }

    @Test // Test method to check if the play button functions and increases the happiness status value
    fun testPlayButton() {                                                                          //(OpenAI, 2024)
        // Click on the Start button
        onView(withId(R.id.btnStart)).perform(click())

        // Click on the Play button
        onView(withId(R.id.playBtn)).perform(click())

        // Check if happiness value increased
        onView(withId(R.id.playTxt)).check(matches(withText("100")))
    }
/*  Reference List:

OpenAI. (2024). ChatGPT3.5 (Feb 13 version). [Large language model]. Available at:
            https://chat.openai.com/ [Accessed 05 May 2024].

*/
}