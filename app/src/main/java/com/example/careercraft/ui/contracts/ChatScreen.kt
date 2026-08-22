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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.careercraft.ui.common.ProfilePicture
import com.example.careercraft.ui.theme.*
import com.example.careercraft.navigation.Routes

@Composable
fun ChatScreen(
    contractId: String,
    navController: NavHostController = rememberNavController(),
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
                // CHAT HEADER WITH PROFILE PICTURE - CLICKABLE
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGrey)
                        .padding(16.dp)
                        .clickable {
                            val otherPartyId = if (state.myId == state.contract.freelancerId)
                                state.contract.clientId
                            else
                                state.contract.freelancerId
                            navController.navigate(Routes.publicProfile(otherPartyId))
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ProfilePicture(
                        photoUrl = state.otherParty.photoUrl,
                        displayName = state.otherParty.displayName,
                        size = 40
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        state.otherParty.displayName,
                        style = MaterialTheme.typography.titleMedium,
                        color = Black
                    )
                    Spacer(Modifier.weight(1f))
                    if (!state.contract.chatActive) {
                        Text("Read-Only", color = Grey, style = MaterialTheme.typography.labelSmall)
                    }
                }

                // MESSAGES
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.messages, key = { it.messageId }) { message ->
                        val isMine = message.senderId == state.myId
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = if (isMine) Arrangement.End else Arrangement.Start
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(if (isMine) DeepGrey else LightGrey)
                                    .padding(horizontal = 14.dp, vertical = 10.dp)
                            ) {
                                Text(
                                    message.content,
                                    color = if (isMine) White else Black,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }

                // INPUT
                if (state.contract.chatActive) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = messageText,
                            onValueChange = { messageText = it },
                            placeholder = { Text("Type a message...") },
                            modifier = Modifier.weight(1f),
                            colors = careerCraftTextFieldColors()
                        )
                        Spacer(Modifier.width(8.dp))
                        Button(
                            onClick = {
                                viewModel.sendMessage(messageText)
                                messageText = ""
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = DeepGrey,
                                contentColor = White
                            )
                        ) {
                            Text("Send")
                        }
                    }
                }
            }
        }
    }
}