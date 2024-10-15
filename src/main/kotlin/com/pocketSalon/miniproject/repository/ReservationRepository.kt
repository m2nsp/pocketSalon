package com.pocketSalon.miniproject.repository

import com.pocketSalon.miniproject.domain.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository

interface ReservationRepository : JpaRepository<Reservation, Long> {
    fun findByMemberId(memberId: String): List<Reservation>
}