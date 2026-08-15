package com.example.careercraft.ui.portfolio

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.careercraft.ui.theme.*

private val categories = listOf("Technology", "Creative", "Physical", "Service")

@Composable
fun PortfolioFormScreen(
    onSaved: () -> Unit,
    viewModel: PortfolioFormViewModel = viewModel()
) {
    val context = LocalContext.current
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf(categories[0]) }
    var description by remember { mutableStateOf("") }
    var selectedUris by remember { mutableStateOf(listOf<Uri>()) }
    val uiState by viewModel.uiState.collectAsState()

    val pickImages = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(5)
    ) { uris -> if (uris.isNotEmpty()) selectedUris = uris }

    LaunchedEffect(uiState) {
        if (uiState is PortfolioFormUiState.Success) onSaved()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Add Project", style = MaterialTheme.typography.titleLarge, color = Black)
        Spacer(Modifier.height(20.dp))

        OutlinedTextField(title, { title = it }, label = { Text("Title") }, singleLine = true, modifier = Modifier.fillMaxWidth(), colors = careerCraftTextFieldColors())
        Spacer(Modifier.height(12.dp))

        Text("Category", color = Grey, style = MaterialTheme.typography.labelSmall)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 4.dp)) {
            categories.forEach { c -> FilterChip(selected = category == c, onClick = { category = c }, label = { Text(c) }) }
        }
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(description, { description = it }, label = { Text("Description (optional)") }, minLines = 3, modifier = Modifier.fillMaxWidth(), colors = careerCraftTextFieldColors())
        Spacer(Modifier.height(16.dp))

        Text("Images (at least 1 required)", color = Grey, style = MaterialTheme.typography.labelSmall)
        Spacer(Modifier.height(8.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(selectedUris) { uri ->
                AsyncImage(
                    model = uri, contentDescription = null, contentScale = ContentScale.Crop,
                    modifier = Modifier.size(72.dp).clip(RoundedCornerShape(10.dp))
                )
            }
        }
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { pickImages.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
            colors = ButtonDefaults.buttonColors(containerColor = LightGrey, contentColor = Black)
        ) { Text("Choose Images") }

        if (uiState is PortfolioFormUiState.Error) {
            Spacer(Modifier.height(8.dp))
            Text((uiState as PortfolioFormUiState.Error).message, color = Red, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {
                val images = selectedUris.mapNotNull { uri ->
                    context.contentResolver.openInputStream(uri)?.use { it.readBytes() }?.let { bytes -> bytes to "jpg" }
                }
                viewModel.submit(title, category, description, images)
            },
            modifier = Modifier.fillMaxWidth().height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White),
            enabled = uiState !is PortfolioFormUiState.Uploading
        ) {
            if (uiState is PortfolioFormUiState.Uploading) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), color = White, strokeWidth = 2.dp)
            } else {
                Text("SUBMIT")
            }
        }
    }
}