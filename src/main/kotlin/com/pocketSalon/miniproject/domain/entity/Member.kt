package com.pocketSalon.miniproject.domain.entity

import jakarta.persistence.*

@Entity
class Member(
    @Column(nullable = false)
    var password: String,

    var phoneNumber: String,        //전화번호는 String으로 처리하는 것이 일반적임

    @Column(nullable = false)
    var name: String
):BaseEntity() {
    @Id
    @Column(name = "id", nullable = false)
    var id: String = "" //ID는 나중에 수동으로 설정

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var reservations: List<Reservation> = mutableListOf()

    @OneToMany(mappedBy = "reviewer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var reviews: List<Review> = mutableListOf()
}