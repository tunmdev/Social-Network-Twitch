package com.tunm17.socialnetworktwitch.presentation.main_feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.tunm17.socialnetworktwitch.presentation.components.Post
import com.tunm17.socialnetworktwitch.presentation.components.StandardScaffold

@Composable
fun MainFeedScreen(
    navController: NavController
) {
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