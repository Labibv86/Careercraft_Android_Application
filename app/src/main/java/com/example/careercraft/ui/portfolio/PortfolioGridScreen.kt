package com.example.careercraft.ui.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.careercraft.ui.theme.*

@Composable
fun PortfolioGridScreen(
    onAddNew: () -> Unit,
    viewModel: PortfolioGridViewModel = viewModel()
) {
    LaunchedEffect(Unit) { viewModel.refresh() }
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is PortfolioGridUiState.Loading -> CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is PortfolioGridUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is PortfolioGridUiState.Ready -> {
                Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("My Portfolio", style = MaterialTheme.typography.titleLarge, color = Black)
                        TextButton(onClick = onAddNew) { Text("+ ADD NEW", color = DeepGrey) }
                    }
                    Spacer(Modifier.height(16.dp))

                    if (state.items.isEmpty()) {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text("No projects yet. Add your first one!", color = Grey)
                        }
                    } else {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(state.items, key = { it.portfolioId }) { item ->
                                Column(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(LightGrey)
                                ) {
                                    AsyncImage(
                                        model = item.images.firstOrNull(),
                                        contentDescription = item.title,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxWidth().height(100.dp)
                                    )
                                    Column(modifier = Modifier.padding(10.dp)) {
                                        Text(item.title, style = MaterialTheme.typography.titleMedium, color = Black, maxLines = 1)
                                        Text(item.category, style = MaterialTheme.typography.labelSmall, color = Grey)
                                        Spacer(Modifier.height(6.dp))
                                        TextButton(onClick = { viewModel.delete(item.portfolioId) }, contentPadding = PaddingValues(0.dp)) {
                                            Text("DELETE", color = Red, style = MaterialTheme.typography.labelSmall)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}