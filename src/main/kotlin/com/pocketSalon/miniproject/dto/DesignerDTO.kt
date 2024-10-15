package com.pocketSalon.miniproject.dto

import com.pocketSalon.miniproject.domain.constant.specialty

data class DesignerDTO(
    val name: String,
    val phoneNumber: String,
    val introduction: String,
    val specialty: specialty
)