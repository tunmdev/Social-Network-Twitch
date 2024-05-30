package com.tunm17.socialnetworktwitch.presentation.main_feed

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.tunm17.socialnetworktwitch.presentation.components.Post
import com.tunm17.socialnetworktwitch.ui.util.Screen

@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Post(post = com.tunm17.socialnetworktwitch.domain.Post(
        username = "Philip Lacker",
        imageUrl = "",
        profilePictureUrl = "",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel felis in dui suscipit scelerisque laoreet sit amet lectus. Vestibulum sed nisi eleifend, rutrum purus ac, hendrerit purus. Suspendisse egestas, dolor at molestie condimentum, nisl enim vehicula mauris, ac ornare velit nulla a turpis.",
        likeCount = 17,
        commentCount = 7
    ))
}