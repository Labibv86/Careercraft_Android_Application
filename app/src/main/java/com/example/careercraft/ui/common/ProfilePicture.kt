package com.example.careercraft.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.LightGrey

@Composable
fun ProfilePicture(
    photoUrl: String?,
    displayName: String,
    size: Int = 40,
    modifier: Modifier = Modifier
) {
    val firstLetter = displayName.firstOrNull()?.toString()?.uppercase() ?: "?"

    Box(
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(LightGrey),
        contentAlignment = Alignment.Center
    ) {
        if (!photoUrl.isNullOrBlank()) {
            AsyncImage(
                model = photoUrl,
                contentDescription = "Profile picture of $displayName",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(size.dp)
                    .clip(CircleShape)
            )
        } else {
            Text(
                text = firstLetter,
                color = Black,
                fontSize = (size * 0.45).sp,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}