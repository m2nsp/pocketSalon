package com.pocketSalon.miniproject.controller

import com.pocketSalon.miniproject.dto.ReservationResponseDTO
import com.pocketSalon.miniproject.service.ReservationService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import java.time.LocalDate

@WebMvcTest(ApiController::class)
class ApiControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockBean
    private lateinit var reservationService: ReservationService

    @Test
    fun `test reservations for Member 1 with Designer 1`() {
        // Given
        val memberId = "JohnisHandsome"
        val expectedReservations = listOf(
            ReservationResponseDTO(
                reservationId = 1,
                designerName = "Seoyeong Han",
                memberName = "John Doe",
                remarks = "예약 내용 1",
                reservationTime = LocalDate.of(2024, 10, 20)
            )
        )

        `when`(reservationService.getReservationsByMember(memberId)).thenReturn(expectedReservations)

        // When & Then
        mockMvc.get("/api/reservations/member/$memberId") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content {
                json("""[{"reservationId":1,"designerName":"Seoyeong Han","memberName":"John Doe","remarks":"예약 내용 1","reservationTime":"2024-10-20"}]""")
            }
        }
    }
}
