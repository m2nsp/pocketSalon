package com.pocketSalon.miniproject.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Reservation(
    @Column(nullable = false)
    var remarks: String,

    @Column(nullable = false)
    var reservationTime: LocalDate,

    var createdAt: LocalDate?
): BaseEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationId", nullable = false)
    var reservationId: Long = 0L

    // 디자이너와 다대일 관계 설정
    @ManyToOne
    @JoinColumn(name = "designerId", nullable = false)
    lateinit var designer: Designer

    // 멤버와 다대일 관계 설정
    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    lateinit var member: Member
}
