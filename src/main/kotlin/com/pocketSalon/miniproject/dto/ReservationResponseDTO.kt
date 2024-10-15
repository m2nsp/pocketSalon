package com.pocketSalon.miniproject.dto

import java.time.LocalDate

data class ReservationResponseDTO(
    val reservationId: Long,
    val designerName: String,
    val memberName: String,
    val remarks: String,
    val reservationTime: LocalDate
)