package com.tunm17.socialnetworktwitch.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunm17.socialnetworktwitch.ui.theme.HintGray
import com.tunm17.socialnetworktwitch.ui.theme.SpaceMedium
import com.tunm17.socialnetworktwitch.ui.theme.SpaceSmall

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    icon: ImageVector,
    contentDescription: String = "",
    alertCount: Int? = null,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = HintGray,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    alertCount?.let {
        require(alertCount >= 0)
    }
    val lineLength = animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300
        ), label = ""
    )


    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        enabled = enabled,
        icon = {
            BadgedBox(badge = {
                if (alertCount != null) {
                    val alertText = if (alertCount > 99) {
                        "99+"
                    } else {
                        alertCount.toString()
                    }
                    Badge {
                        Text(text = alertText)
                    }
                }
                }) {
                    Box(
                        modifier = Modifier
                            .padding(SpaceSmall)
                            .drawBehind {
                                if (selected) {
                                    drawLine(
                                        color = if (selected) selectedColor else unselectedColor,
                                        start = Offset(
                                            0f - lineLength.value * 2.dp.toPx(),
                                            size.height + 5.dp.toPx()
                                        ),
                                        end = Offset(
                                            size.width + lineLength.value * 2.dp.toPx(),
                                            size.height + 5.dp.toPx()
                                        ),
                                        strokeWidth = 2.dp.toPx(),
                                        cap = StrokeCap.Round
                                    )
                                }
                            }
//                            .background(Color.Red)
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = contentDescription,
                            modifier = Modifier.align(Alignment.Center),
                            tint = if (selected) MaterialTheme.colorScheme.primary else HintGray
                        )
                    }
            }
        },
//        label = {
//            Text(
//                text = contentDescription,
//                color = if (selected) MaterialTheme.colorScheme.primary else HintGray
//            )
//        },

    )
}