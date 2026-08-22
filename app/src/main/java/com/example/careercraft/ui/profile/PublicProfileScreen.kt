package com.example.careercraft.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.careercraft.ui.common.ProfilePicture
import com.example.careercraft.ui.common.DashboardCard
import com.example.careercraft.ui.theme.*
import com.example.careercraft.navigation.Routes

@Composable
fun PublicProfileScreen(
    userId: String,
    navController: NavHostController = rememberNavController(),
    viewModel: PublicProfileViewModel = viewModel(factory = PublicProfileViewModelFactory(userId))
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is PublicProfileUiState.Loading ->
                CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is PublicProfileUiState.Error ->
                Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is PublicProfileUiState.Ready -> {
                val data = state.data
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // HEADER
                    item {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            ProfilePicture(
                                photoUrl = data.user.photoUrl,
                                displayName = data.user.displayName,
                                size = 100
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                data.user.displayName,
                                style = MaterialTheme.typography.titleLarge,
                                color = Black
                            )
                            Text(
                                data.user.role.capitalize(),
                                style = MaterialTheme.typography.bodyMedium,
                                color = Grey
                            )
                            if (data.user.role == "freelancer") {
                                Row(
                                    modifier = Modifier.padding(top = 4.dp),
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    Text(
                                        "⭐ ${data.user.ratingScore}",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Black
                                    )
                                    Text(
                                        "${data.user.totalReviews} reviews",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Grey
                                    )
                                    Text(
                                        "${data.completedContracts} completed",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Grey
                                    )
                                }
                            } else {
                                // Client ratings
                                Row(
                                    modifier = Modifier.padding(top = 4.dp),
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    Text(
                                        "⭐ ${data.user.ratingScore}",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Black
                                    )
                                    Text(
                                        "${data.user.totalReviews} reviews",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Grey
                                    )
                                }
                            }
                        }
                    }

                    // BIO
                    if (!data.user.bio.isNullOrBlank()) {
                        item {
                            DashboardCard(
                                title = "About",
                                subtitle = data.user.bio ?: ""
                            )
                        }
                    }

                    // CONTACT INFO
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .background(LightGrey)
                                .padding(16.dp)
                        ) {
                            Text("Contact", style = MaterialTheme.typography.titleMedium, color = Black)
                            Spacer(Modifier.height(8.dp))
                            if (!data.user.email.isNullOrBlank()) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(vertical = 2.dp)
                                ) {
                                    Text("📧 ", style = MaterialTheme.typography.bodyMedium)
                                    Text(data.user.email, style = MaterialTheme.typography.bodyMedium, color = Black)
                                }
                            } else {
                                Text(
                                    "Contact information not shared",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Grey
                                )
                            }
                        }
                    }

                    // SKILLS (for freelancers)
                    if (data.user.role == "freelancer" && !data.user.skills.isNullOrEmpty()) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(LightGrey)
                                    .padding(16.dp)
                            ) {
                                Text("Skills", style = MaterialTheme.typography.titleMedium, color = Black)
                                Spacer(Modifier.height(8.dp))
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier.wrapContentWidth()
                                ) {
                                    data.user.skills?.forEach { skill ->
                                        AssistChip(
                                            onClick = { /* No action */ },
                                            label = { Text(skill) },
                                            colors = AssistChipDefaults.assistChipColors(
                                                containerColor = White,
                                                labelColor = Black
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // CAREER PATH (for freelancers)
                    if (data.user.role == "freelancer" && !data.user.careerPath.isNullOrBlank()) {
                        item {
                            DashboardCard(
                                title = "Career Path",
                                subtitle = data.user.careerPath ?: ""
                            )
                        }
                    }

                    // PORTFOLIO (for freelancers)
                    if (data.user.role == "freelancer" && data.portfolio.isNotEmpty()) {
                        item {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Portfolio", style = MaterialTheme.typography.titleMedium, color = Black)
                                Spacer(Modifier.height(8.dp))
                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    items(data.portfolio) { item ->
                                        Column(
                                            modifier = Modifier
                                                .width(150.dp)
                                                .clip(RoundedCornerShape(14.dp))
                                                .background(LightGrey)
                                        ) {
                                            AsyncImage(
                                                model = item.images.firstOrNull(),
                                                contentDescription = item.title,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(100.dp)
                                            )
                                            Column(modifier = Modifier.padding(10.dp)) {
                                                Text(
                                                    item.title,
                                                    style = MaterialTheme.typography.titleMedium,
                                                    color = Black,
                                                    maxLines = 1
                                                )
                                                Text(
                                                    item.category,
                                                    style = MaterialTheme.typography.labelSmall,
                                                    color = Grey
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // REVIEWS (with reviewer names)
                    if (data.reviews.isNotEmpty()) {
                        item {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Reviews", style = MaterialTheme.typography.titleMedium, color = Black)
                                Spacer(Modifier.height(8.dp))
                                data.reviews.take(5).forEach { reviewWithReviewer ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp),
                                        colors = CardDefaults.cardColors(containerColor = LightGrey)
                                    ) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                ProfilePicture(
                                                    photoUrl = reviewWithReviewer.reviewerPhotoUrl,
                                                    displayName = reviewWithReviewer.reviewerName,
                                                    size = 24
                                                )
                                                Spacer(Modifier.width(8.dp))
                                                Text(
                                                    reviewWithReviewer.reviewerName,
                                                    style = MaterialTheme.typography.titleSmall,
                                                    color = Black
                                                )
                                                Spacer(Modifier.weight(1f))
                                                Text(
                                                    "Rating: ${reviewWithReviewer.review.rating}",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = if (reviewWithReviewer.review.rating >= 0) Black else Red
                                                )
                                            }
                                            if (!reviewWithReviewer.review.feedback.isNullOrBlank()) {
                                                Spacer(Modifier.height(4.dp))
                                                Text(
                                                    reviewWithReviewer.review.feedback,
                                                    style = MaterialTheme.typography.bodyMedium,
                                                    color = Grey
                                                )
                                            }
                                        }
                                    }
                                }
                                if (data.reviews.size > 5) {
                                    Text(
                                        "And ${data.reviews.size - 5} more reviews...",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Grey,
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}