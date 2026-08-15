package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PortfolioItem(
    @SerialName("portfolio_id") val portfolioId: String,
    @SerialName("freelancer_id") val freelancerId: String,
    val title: String,
    val category: String,
    val description: String? = null,
    val images: List<String>
)

@Serializable
data class PortfolioInsert(
    @SerialName("freelancer_id") val freelancerId: String,
    val title: String,
    val category: String,
    val description: String?,
    val images: List<String>
)