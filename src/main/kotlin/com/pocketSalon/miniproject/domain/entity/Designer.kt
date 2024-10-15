package com.pocketSalon.miniproject.domain.entity

import com.fasterxml.jackson.databind.ser.Serializers.Base
import com.pocketSalon.miniproject.domain.constant.specialty
import com.pocketSalon.miniproject.dto.DesignerDTO
import com.pocketSalon.miniproject.dto.ReviewResponseDTO
import com.pocketSalon.miniproject.repository.DesignerRepository
import jakarta.persistence.*

@Entity
class Designer(
    name: String,
    phoneNumber: String,
    introduction: String,

    @Enumerated(EnumType.STRING)
    var specialty: specialty // specialty 필드
):BaseEntity() {
    @Id
    @Column(name = "D_id", nullable = false)
    var D_id: String = ""

    var name: String = name
    var phoneNumber: String = phoneNumber
    var introduction: String = introduction

    @OneToMany(mappedBy = "designer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var reservations: List<Reservation> = mutableListOf()

    @OneToMany(mappedBy = "designer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var reviews: List<Review> = mutableListOf()

}