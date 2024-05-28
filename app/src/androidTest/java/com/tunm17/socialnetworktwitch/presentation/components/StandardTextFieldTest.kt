package com.tunm17.socialnetworktwitch.presentation.components

import android.transition.Scene
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
import com.tunm17.socialnetworktwitch.ui.MainActivity
import com.tunm17.socialnetworktwitch.ui.theme.SocialNetworkTwitchTheme
import com.tunm17.socialnetworktwitch.ui.util.Screen
import com.tunm17.socialnetworktwitch.ui.util.TestTags.PASSWORD_TOGGLE
import com.tunm17.socialnetworktwitch.ui.util.TestTags.STANDARD_TEXT_FIELD
import com.tunm17.socialnetworktwitch.util.Constants
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StandardTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun enterTooLongString_maxLengthNotExceeded() {
        composeTestRule.setContent {
            var text by remember {
                mutableStateOf("")
            }
            SocialNetworkTwitchTheme {
                StandardTextField(
                    text = text,
                    onValueChange = {
                        text = it
                    },
                    maxLength = 5,
                    modifier = Modifier
                        .semantics {
                            testTag = STANDARD_TEXT_FIELD
                        }
                )
            }
        }

        val expectedString = "aaaaa"
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextClearance()
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput(expectedString)
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput("a")

        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .assertTextEquals(expectedString)
    }

    @Test
    fun enterPassword_toggleVisibility_passwordVisible() {
        composeTestRule.setContent {
            var text by remember {
                mutableStateOf("")
            }
            SocialNetworkTwitchTheme {
                StandardTextField(
                    text = text,
                    onValueChange = {
                        text = it
                    },
                    maxLength = 5,
                    keyboardType = KeyboardType.Password
                )
            }
        }
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput("aaaaa")

        composeTestRule
            .onNodeWithTag(PASSWORD_TOGGLE)
    }
}
