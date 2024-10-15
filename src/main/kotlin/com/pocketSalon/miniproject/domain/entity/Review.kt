package com.pocketSalon.miniproject.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Review(
    @Column(nullable = false)
    var rating: Number,

    @Column(columnDefinition = "TEXT")
    var content: String,

    @Column(nullable = false)
    var createdAt: LocalDate
):BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId", nullable = false)
    var reviewId: Long = 0L

    //외래 키인 값들은 따로 필드로 생성해주지 않아도 됨

    @ManyToOne
    @JoinColumn(name = "reviewerId", nullable = false)
    lateinit var reviewer: Member  // ManyToOne 관계로 Members 엔티티와 연결  -- 할당이 필요하므로 lateinit 사용

    @ManyToOne
    @JoinColumn(name = "designerId", nullable = false)
    lateinit var designer: Designer  // ManyToOne 관계로 Designer 엔티티와 연결
}
