package com.tunm17.socialnetworktwitch.domain.models
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val contentDescription: String,
    val alertCount: Int? = null
)
