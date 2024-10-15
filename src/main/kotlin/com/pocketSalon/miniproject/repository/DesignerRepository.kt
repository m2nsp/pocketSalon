package com.pocketSalon.miniproject.repository

import com.pocketSalon.miniproject.domain.entity.Designer
import org.springframework.data.jpa.repository.JpaRepository

interface DesignerRepository : JpaRepository<Designer, String> {

}