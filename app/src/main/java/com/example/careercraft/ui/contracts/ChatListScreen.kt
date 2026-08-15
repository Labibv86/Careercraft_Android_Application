package com.example.careercraft.ui.contracts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.common.DashboardCard
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.Red
import com.example.careercraft.ui.theme.White

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
                            DashboardCard(
                                title = chat.otherPartyName,
                                subtitle = chat.preview,
                                modifier = Modifier.clickable { onChatClick(chat.contractId) }
                            )
                        }
                    }
                }
            }
        }
    }
}