package com.example.careercraft.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.Grey
import com.example.careercraft.ui.theme.LightGrey
import com.example.careercraft.ui.theme.MidGrey
import com.example.careercraft.ui.theme.White

@Composable
fun SelectableCard(
    title: String,
    subtitle: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(if (selected) LightGrey else White)
            .border(
                BorderStroke(if (selected) 2.dp else 1.dp, if (selected) Black else MidGrey),
                RoundedCornerShape(14.dp)
            )
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Text(title, style = MaterialTheme.typography.titleMedium, color = Black)
        Spacer(Modifier.height(4.dp))
        Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = Grey)
    }
}