package com.pocketSalon.miniproject.dto

data class MemberRequestDTO (
    val id: String,
    val password: String,
    val phoneNumber: String,
    val name: String
)