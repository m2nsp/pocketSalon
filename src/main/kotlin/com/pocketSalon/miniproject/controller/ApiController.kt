package com.pocketSalon.miniproject.controller

import com.pocketSalon.miniproject.dto.ReservationResponseDTO
import com.pocketSalon.miniproject.service.ReservationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class ApiController(
    private val reservationService: ReservationService
) {

    @GetMapping("/test")
    fun test(): String{
        return "OK"
    }

    // memberId를 @PathVariable로 받아옴
    @GetMapping("/reservations/member/{memberId}")
    fun getReservationsByMember(@PathVariable memberId: String): List<ReservationResponseDTO> {
        return reservationService.getReservationsByMember(memberId)
    }

}