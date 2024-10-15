package com.pocketSalon.miniproject.domain.repository

import com.pocketSalon.miniproject.domain.entity.Designer
import com.pocketSalon.miniproject.domain.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository

interface DesignerRepository : JpaRepository<Designer, String> {
}