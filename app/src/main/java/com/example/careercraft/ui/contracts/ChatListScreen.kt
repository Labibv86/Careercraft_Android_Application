package com.example.careercraft.ui.contracts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.common.ProfilePicture
import com.example.careercraft.ui.theme.*

@Composable
fun ChatListScreen(
    onChatClick: (String) -> Unit,
    viewModel: ChatListViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is ChatListUiState.Loading -> CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is ChatListUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is ChatListUiState.Ready -> {
                if (state.chats.isEmpty()) {
                    Text(
                        "No conversations yet. Once you're hired or hire someone, the chat appears here automatically.",
                        color = Black,
                        modifier = Modifier.align(Alignment.Center).padding(24.dp)
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Text("Messages", style = MaterialTheme.typography.titleLarge, color = Black)
                            Spacer(Modifier.height(4.dp))
                        }
                        items(state.chats, key = { it.contractId }) { chat ->
                            // REPLACE DashboardCard with custom row
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(LightGrey)
                                    .clickable { onChatClick(chat.contractId) }
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ProfilePicture(
                                    photoUrl = chat.otherPartyPhotoUrl,
                                    displayName = chat.otherPartyName,
                                    size = 48
                                )
                                Spacer(Modifier.width(12.dp))
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        chat.otherPartyName,
                                        style = MaterialTheme.typography.titleMedium,
                                        color = Black
                                    )
                                    Text(
                                        chat.preview,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Grey,
                                        maxLines = 1
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