package com.pocketSalon.miniproject.domain

import com.pocketSalon.miniproject.domain.constant.specialty
import com.pocketSalon.miniproject.domain.entity.Designer
import com.pocketSalon.miniproject.domain.entity.Member
import com.pocketSalon.miniproject.domain.entity.Reservation
import com.pocketSalon.miniproject.domain.repository.DesignerRepository
import com.pocketSalon.miniproject.domain.repository.MemberRepository
import com.pocketSalon.miniproject.domain.repository.ReservationRepository
import com.pocketSalon.miniproject.domain.repository.ReviewRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataInitializer (
    private val designerRepository: DesignerRepository,
    private val memberRepository: MemberRepository,
    private val reservationRepository: ReservationRepository,
    private val reviewRepository: ReviewRepository
){
    @PostConstruct
    fun initializeData(){
        println("스프링 실행되었습니다. 테스트 데이터를 초기화 합니다.")

        //멤버 리스트 생성
        val members = mutableListOf<Member>(
            Member(
                password = "password123",
                phoneNumber = "010-1234-5678",
                name = "John Doe"
            ).apply {
                id = "JohnisHandsome"
            },
            Member(
                password = "ilovedog1004",
                phoneNumber = "010-9999-8888",
                name = "Minsu Lee"
            ).apply {
                id = "dogiscute99"
            }
            // 추가멤버 생성
        )
        //멤버 저장
        memberRepository.saveAll(members)


        val designers = mutableListOf<Designer>(
            Designer(
                name = "Seoyeong Han",
                phoneNumber = "010-2345-3456",
                introduction = "5년차 수석 헤어디자이너입니다.",
                specialty = specialty.PERM
            ).apply {
                designerId = "디자이너_아이디_1"       //수동으로 디자이너 아이디 설정
            },
            Designer(
                name = "SungJae Ann",
                phoneNumber = "010-5656-7878",
                introduction = "10년차 헤어디자이너로 김땡땡님 작업함.",
                specialty = specialty.CUTTING
            ).apply {
                designerId = "디자이너_아이디_2"
            }
            //추가 디자이너 생성
        )
        designerRepository.saveAll(designers)

        val reservations = mutableListOf<Reservation>(
            Reservation(
                remarks = "예약 내용 1",
                reservationTime = LocalDate.of(2024, 10, 20),
                createdAt = LocalDate.now()
            ).apply {
                //디자이너 및 멤버 설정
                designer = designerRepository.findById("디자이너_아이디_1").orElseThrow{ Exception("디자이너를 찾을 수 없습니다.") }
                member = members[0]
            },
            Reservation(
                remarks = "예약 내용 2",
                reservationTime = LocalDate.of(2024, 10, 21),
                createdAt = LocalDate.now()
            ).apply {
                designer = designerRepository.findById("디자이너_아이디_1").orElseThrow { Exception("디자이너를 찾을 수 없습니다.") }
                member = members[1] // 두 번째 멤버
            },
            Reservation(
                remarks = "예약 내용 3",
                reservationTime = LocalDate.of(2024, 10, 22),
                createdAt = LocalDate.now()
            ).apply {
                designer = designerRepository.findById("디자이너_아이디_2").orElseThrow { Exception("디자이너를 찾을 수 없습니다.") }
                member = members[0] // 첫 번째 멤버
            }
        )
    }
}