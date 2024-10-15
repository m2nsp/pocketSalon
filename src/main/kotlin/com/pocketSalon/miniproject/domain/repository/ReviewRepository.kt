package com.pocketSalon.miniproject.domain.repository

import com.pocketSalon.miniproject.domain.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {

}