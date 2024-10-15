package com.pocketSalon.miniproject.dto

data class ReviewResponseDTO(
    val reviewId: Long,
    val reviewerName: String,
    val designerName: String,
    val rating: Int,
    val content: String
)