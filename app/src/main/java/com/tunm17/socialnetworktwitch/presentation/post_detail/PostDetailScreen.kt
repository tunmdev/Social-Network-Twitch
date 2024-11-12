package com.tunm17.socialnetworktwitch.presentation.post_detail

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tunm17.socialnetworktwitch.R
import com.tunm17.socialnetworktwitch.domain.models.Comment
import com.tunm17.socialnetworktwitch.domain.models.Post
import com.tunm17.socialnetworktwitch.presentation.components.ActionRow
import com.tunm17.socialnetworktwitch.presentation.components.StandardToolbar
import com.tunm17.socialnetworktwitch.ui.theme.MediumGray
import com.tunm17.socialnetworktwitch.ui.theme.ProfilePictureSize
import com.tunm17.socialnetworktwitch.ui.theme.ProfilePictureSizeSmall
import com.tunm17.socialnetworktwitch.ui.theme.SpaceLarge
import com.tunm17.socialnetworktwitch.ui.theme.SpaceMedium
import com.tunm17.socialnetworktwitch.ui.theme.SpaceSmall

@Composable
fun PostDetailScreen(
    navController: NavController,
    post: Post
) {
    Column(
        modifier = Modifier.fillMaxSize()
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
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Spacer(modifier = Modifier.height(SpaceLarge))
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .offset(y = ProfilePictureSize / 2f)
                                .clip(MaterialTheme.shapes.medium)
                                .shadow(5.dp)
                                .background(MediumGray)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.kermit),
                                contentDescription = "Post image",
                                modifier = Modifier.fillMaxWidth()
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(SpaceLarge)
                            ) {
                                ActionRow(
                                    username = "Philipp Lackner",
                                    modifier = Modifier.fillMaxWidth(),
                                    onLikeClick = { isLike ->

                                    },
                                    onCommentClick = {

                                    },
                                    onShareClick = {

                                    },
                                    onUsernameClick = { username ->

                                    }
                                )
                                Spacer(modifier = Modifier.height(SpaceSmall))

                                Text(
                                    text = post.description,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.height(SpaceMedium))

                                Text(
                                    text = stringResource(
                                        id = R.string.liked_by_x_people,
                                        post.likeCount
                                    ),
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }

                        Image(
                            painter = painterResource(id = R.drawable.philipp),
                            contentDescription = "Profile picture",
                            modifier = Modifier
                                .size(ProfilePictureSize)
                                .clip(CircleShape)
                                .align(Alignment.TopCenter)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(SpaceLarge))
            }

            items(20) {
                Comment(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = SpaceLarge,
                            vertical = SpaceSmall
                        ),
                    comment = Comment(
                        username = "Philipp Lackner$it",
                        comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel felis in dui suscipit scelerisque laoreet sit amet lectus. Vestibulum sed nisi eleifend, rutrum purus ac, hendrerit purus."
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun PostDetailPreview() {
    PostDetailScreen(
        navController = rememberNavController(),
        post = Post(
            username = "Philip Lacker",
            imageUrl = "",
            profilePictureUrl = "",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel felis in dui suscipit scelerisque laoreet sit amet lectus. Vestibulum sed nisi eleifend, rutrum purus ac, hendrerit purus. Suspendisse egestas, dolor at molestie condimentum, nisl enim vehicula mauris, ac ornare velit nulla a turpis.",
            likeCount = 17,
            commentCount = 7
        )
    )
}

@Composable
fun Comment(
    modifier: Modifier = Modifier,
    comment: Comment = Comment(),
    onLikeClick: (Boolean) -> Unit = {}
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onSurface), // Set background color here
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.philipp),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(ProfilePictureSizeSmall)
                    )
                    Spacer(modifier = Modifier.width(SpaceSmall))
                    Text(
                        text = comment.username,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Text(
                    text = "2 days ago",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(SpaceMedium))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.height(SpaceMedium))

                IconButton(onClick = {
                    onLikeClick(comment.isLiked)
                }) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = if (comment.isLiked) {
                            stringResource(id = R.string.unlike)
                        } else stringResource(id = R.string.like)
                    )
                }
            }

            Spacer(modifier = Modifier.height(SpaceMedium))
            Text(
                text = stringResource(id = R.string.liked_by_x_people, comment.likeCount),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}