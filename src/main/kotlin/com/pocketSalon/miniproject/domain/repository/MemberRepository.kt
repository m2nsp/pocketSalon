package com.pocketSalon.miniproject.domain.repository

import com.pocketSalon.miniproject.domain.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, String> {

}