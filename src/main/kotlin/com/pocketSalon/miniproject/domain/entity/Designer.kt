package com.pocketSalon.miniproject.domain.entity

import com.fasterxml.jackson.databind.ser.Serializers.Base
import com.pocketSalon.miniproject.domain.constant.specialty
import jakarta.persistence.*

@Entity
class Designer(
    name: String,
    phoneNumber: String,
    introduction: String,
    specialty: specialty
):BaseEntity() {
    @Id
    @Column(name = "D_id", nullable = false)
    var D_id: String = ""

    @OneToMany(mappedBy = "designer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var reservations: List<Reservation> = mutableListOf()

    @OneToMany(mappedBy = "designer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var reviews: List<Review> = mutableListOf()
}