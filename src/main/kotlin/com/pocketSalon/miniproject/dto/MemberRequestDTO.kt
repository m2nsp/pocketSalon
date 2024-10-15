package com.pocketSalon.miniproject.dto

import com.pocketSalon.miniproject.domain.entity.Member

data class MemberRequestDTO(
    val id: String,
    val password: String,
    val phoneNumber: String,
    val name: String
) {
    // Member 엔티티를 사용하여 DTO 생성자
    constructor(member: Member) : this(
        id = member.id,
        password = member.password,  // 엔티티에서 패스워드 가져오기
        phoneNumber = member.phoneNumber,  // 엔티티에서 전화번호 가져오기
        name = member.name  // 엔티티에서 이름 가져오기
    )
}
