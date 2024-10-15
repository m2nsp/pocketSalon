package com.pocketSalon.miniproject.dto

data class ReviewRequestDTO(
    val reviewerId: String,
    val designerId: String,
    val rating: Int,
    val content: String
)