package com.pocketSalon.miniproject.service

import com.pocketSalon.miniproject.dto.DesignerDTO
import com.pocketSalon.miniproject.repository.ReservationRepository
import com.pocketSalon.miniproject.dto.ReservationResponseDTO
import com.pocketSalon.miniproject.dto.ReviewResponseDTO
import com.pocketSalon.miniproject.repository.DesignerRepository
import org.springframework.stereotype.Service

@Service
class ReservationService(
    private val reservationRepository: ReservationRepository
) {
    //사용자아이디로 해당 사용자의 예약 조회하는 함수
    fun getReservationsByMember(memberId: String): List<ReservationResponseDTO> {
        val reservations = reservationRepository.findByMemberId(memberId)

        return reservations.map { reservation ->
            ReservationResponseDTO(
                reservationId = reservation.reservationId,
                designerName = reservation.designer.name,
                memberName = reservation.member.name,
                remarks = reservation.remarks,
                reservationTime = reservation.reservationTime
            )
        }
    }
}
