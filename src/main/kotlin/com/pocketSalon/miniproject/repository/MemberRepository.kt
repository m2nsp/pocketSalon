package com.pocketSalon.miniproject.repository

import com.pocketSalon.miniproject.domain.entity.Designer
import com.pocketSalon.miniproject.domain.entity.Members
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Members, String> {

}