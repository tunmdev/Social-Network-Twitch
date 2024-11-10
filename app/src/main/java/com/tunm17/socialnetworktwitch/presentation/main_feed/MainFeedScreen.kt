package com.tunm17.socialnetworktwitch.presentation.main_feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.tunm17.socialnetworktwitch.R
import com.tunm17.socialnetworktwitch.presentation.components.Post
import com.tunm17.socialnetworktwitch.presentation.components.StandardScaffold
import com.tunm17.socialnetworktwitch.presentation.components.StandardToolbar

@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            navActions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            },

        )
        Post(
            post = com.tunm17.socialnetworktwitch.domain.models.Post(
                username = "Philip Lacker",
                imageUrl = "",
                profilePictureUrl = "",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel felis in dui suscipit scelerisque laoreet sit amet lectus. Vestibulum sed nisi eleifend, rutrum purus ac, hendrerit purus. Suspendisse egestas, dolor at molestie condimentum, nisl enim vehicula mauris, ac ornare velit nulla a turpis.",
                likeCount = 17,
                commentCount = 7
            )
        )
    }
}