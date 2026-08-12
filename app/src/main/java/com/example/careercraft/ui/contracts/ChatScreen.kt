package com.example.careercraft.ui.contracts

import androidx.compose.foundation.background
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
import com.example.careercraft.ui.theme.*

@Composable
fun ChatScreen(
    contractId: String,
    viewModel: ChatViewModel = viewModel(factory = ChatViewModelFactory(contractId))
) {
    var messageText by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is ChatUiState.Loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Black)
            }
            is ChatUiState.Error -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(state.message, color = Red, modifier = Modifier.padding(24.dp))
            }
            is ChatUiState.Ready -> {
                if (!state.contract.chatActive) {
                    Box(modifier = Modifier.fillMaxWidth().background(LightGrey).padding(8.dp), contentAlignment = Alignment.Center) {
                        Text("This contract is complete. Chat is read-only.", color = Grey, style = MaterialTheme.typography.labelSmall)
                    }
                }
                LazyColumn(
                    modifier = Modifier.weight(1f).fillMaxWidth().padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.messages, key = { it.messageId }) { message ->
                        val isMine = message.senderId == state.myId
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = if (isMine) Arrangement.End else Arrangement.Start) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(if (isMine) DeepGrey else LightGrey)
                                    .padding(horizontal = 14.dp, vertical = 10.dp)
                            ) {
                                Text(message.content, color = if (isMine) White else Black, style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
                if (state.contract.chatActive) {
                    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = messageText,
                            onValueChange = { messageText = it },
                            placeholder = { Text("Type a message...") },
                            modifier = Modifier.weight(1f),
                            colors = careerCraftTextFieldColors()
                        )
                        Spacer(Modifier.width(8.dp))
                        Button(
                            onClick = { viewModel.sendMessage(messageText); messageText = "" },
                            colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White)
                        ) { Text("Send") }
                    }
                }
            }
        }
    }
}