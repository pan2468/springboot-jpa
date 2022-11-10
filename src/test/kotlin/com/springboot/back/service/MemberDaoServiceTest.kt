package com.springboot.back.service

import com.springboot.back.entity.Member
import com.springboot.back.repository.BookRepository
import com.springboot.back.repository.MemberRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import org.springframework.transaction.annotation.Transactional
import org.junit.jupiter.api.Assertions.assertEquals

@SpringBootTest
@TestPropertySource(locations = ["classpath:application.properties"])
@ActiveProfiles("test")
class MemberDaoServiceTest @Autowired constructor(
    val memberRepository: MemberRepository,
    val bookRepository: BookRepository
){

    @Test
    @Transactional
    @DisplayName("회워가입 테스트")
    fun member_sign (){
        //given
        val member: Member = Member(
            id = 1L,
            email = "pantest@test.com",
            name = "홍길동",
            password = "1234",
            address = "경기도 부천시",
            phone = "010-1111-2222",
            registration = "150825-1185111"
        )
        //when
        val memberEntity: Member = memberRepository.save(member)
        println(memberEntity.toString()) // 회원 값 불어오기

        //then
        assertEquals(memberEntity.email,"pantest@test.com")
        assertEquals(memberEntity.name,"홍길동")
        assertEquals(memberEntity.password,"1234")
        assertEquals(memberEntity.address,"경기도 부천시")
        assertEquals(memberEntity.phone,"010-1111-2222")
        assertEquals(memberEntity.registration,"150825-1185111")
    }

//    @Test
//    @Transactional(readOnly = true)
//    @DisplayName("회원과 도서 조인 매핑 테스트")
//    fun book_join_test (){
//        //given
//
//
//        //when
//
//
//        //then
//    }

}