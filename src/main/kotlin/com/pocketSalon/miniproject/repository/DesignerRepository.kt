package com.pocketSalon.miniproject.repository

import com.pocketSalon.miniproject.domain.entity.Designer
import com.pocketSalon.miniproject.domain.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository

interface DesignerRepository : JpaRepository<Designer, String> {
    fun findByDesignerId(designerId: String): List<Reservation>
}