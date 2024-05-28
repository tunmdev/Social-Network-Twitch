package com.tunm17.socialnetworktwitch.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
import com.tunm17.socialnetworktwitch.ui.MainActivity
import com.tunm17.socialnetworktwitch.ui.theme.SocialNetworkTwitchTheme
import com.tunm17.socialnetworktwitch.ui.util.Screen
import com.tunm17.socialnetworktwitch.util.Constants
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun splashScreen_displayAndDisappears() = runBlockingTest {
        composeTestRule.setContent {
            SocialNetworkTwitchTheme {
                SplashScreen(navController = navController)
            }
        }
        composeTestRule.onNodeWithContentDescription(label = "Logo").assertExists()
    }
}
















