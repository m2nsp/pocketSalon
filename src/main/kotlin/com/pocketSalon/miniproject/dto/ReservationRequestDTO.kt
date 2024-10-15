package com.pocketSalon.miniproject.dto

import java.time.LocalDate

data class ReservationRequestDTO(
    val designerId: String,
    val memberId: String,
    val remarks: String,
    val reservationTime: LocalDate
)