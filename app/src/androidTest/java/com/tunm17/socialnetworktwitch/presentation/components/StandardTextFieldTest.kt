package com.tunm17.socialnetworktwitch.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tunm17.socialnetworktwitch.presentation.login.LoginScreen
import com.tunm17.socialnetworktwitch.ui.theme.SocialNetworkTwitchTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.junit.runners.JUnit4

@RunWith(AndroidJUnit4::class)
class StandardTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {

    }

    fun enterTooLongString_maxLengthNotExceeded() {

    }
}