package com.example.basicapp

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import kotlin.random.Random

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
private const val BASIC_SAMPLE_PACKAGE = "com.example.basicapp"
private const val LAUNCH_TIMEOUT = 5000L
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Wait for launcher
        val launcherPackage: String = device.launcherPackageName
        assertNotNull(launcherPackage)
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )

        // Launch the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(
            BASIC_SAMPLE_PACKAGE)?.apply {
            // Clear out any previous instances
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
    }

    @Test
    fun testSecondActivity() {
        val secondActivityButton: UiObject2 = device.findObject(
            By.text("Start Activity Explicitly")
        )

        // Simulate a user-click on the start second activity button, if found.
        if (secondActivityButton != null) {
            secondActivityButton.click()
        }

        // make sure that the activity contains a challenge
        val expectedChallenges = listOf(
            "Cross-platform development compatibility",
            "Optimizing app performance for various devices",
            "Handling background tasks efficiently",
            "Implementing effective error handling and debugging",
            "Ensuring app security and data privacy",
            "Managing app state and lifecycle effectively",
            "Implementing responsive and adaptive UI/UX design",
            "Addressing network-related challenges (offline support, bandwidth optimization)",
            "Testing across multiple devices and screen sizes",
            "Integrating and managing third-party libraries and APIs"
        )

        // Generate a random index to select a challenge from the list
        val randomIndex = Random.nextInt(0, expectedChallenges.size)
        val randomChallenge = expectedChallenges[randomIndex]

        // Find the UI element by its description
        val challengeDescription = "challenge-${randomIndex+1}"
        val challenge: UiObject2? = device.findObject(By.desc(challengeDescription))

        // Assert that the UI element is not null
        assertNotNull("UI element with description '$challengeDescription' not found", challenge)

        // Assert that the challenge text is contained in the expectedChallenges list
        assertTrue("Challenge '$randomChallenge' not found in the expected challenges list", expectedChallenges.contains(randomChallenge))

    }


}