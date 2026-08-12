package com.example.careercraft.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.common.SelectableCard
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.DeepGrey
import com.example.careercraft.ui.theme.Red
import com.example.careercraft.ui.theme.White

private data class CategoryOption(val key: String, val title: String, val sample: String)

private val categoryOptions = listOf(
    CategoryOption("Technology", "\uD83D\uDCBB Technology & Remote", "Software Engineer, Data Scientist..."),
    CategoryOption("Creative", "\uD83C\uDFA8 Creative & Design", "UI/UX Designer, Content Writer..."),
    CategoryOption("Physical", "\uD83C\uDFD7\uFE0F Physical & Labor", "Warehouse Worker, Landscaper..."),
    CategoryOption("Service", "\uD83D\uDECE\uFE0F Service & Public", "Barista, Customer Service Rep...")
)

@Composable
fun CategoryPickerScreen(
    onCategoriesSaved: () -> Unit,
    viewModel: OnboardingViewModel = viewModel()
) {
    var selected by remember { mutableStateOf(setOf<String>()) }
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is ProfileUiState.Success) {
            onCategoriesSaved()
            viewModel.resetState()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Choose Categories", style = MaterialTheme.typography.titleLarge, color = Black)
        Spacer(Modifier.height(4.dp))
        Text("Pick one or more that fit you", style = MaterialTheme.typography.bodyMedium, color = Black)
        Spacer(Modifier.height(20.dp))

        categoryOptions.forEach { option ->
            SelectableCard(
                title = option.title,
                subtitle = option.sample,
                selected = selected.contains(option.key),
                onClick = {
                    selected = if (selected.contains(option.key)) selected - option.key else selected + option.key
                }
            )
            Spacer(Modifier.height(12.dp))
        }

        if (uiState is ProfileUiState.Error) {
            Text((uiState as ProfileUiState.Error).message, color = Red, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(8.dp))
        }

        Button(
            onClick = { viewModel.saveCategories(selected.toList()) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White),
            enabled = selected.isNotEmpty() && uiState !is ProfileUiState.Loading
        ) {
            if (uiState is ProfileUiState.Loading) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), color = White, strokeWidth = 2.dp)
            } else {
                Text("CONTINUE")
            }
        }
    }
}