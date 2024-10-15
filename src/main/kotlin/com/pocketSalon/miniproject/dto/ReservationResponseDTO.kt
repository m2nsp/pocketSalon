package com.pocketSalon.miniproject.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class ReservationResponseDTO(
    val reservationId: Long,
    val designerName: String,
    val memberName: String,
    val remarks: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val reservationTime: LocalDate
)