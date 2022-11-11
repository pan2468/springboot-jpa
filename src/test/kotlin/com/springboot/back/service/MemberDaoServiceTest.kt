package com.springboot.back.service

import com.springboot.back.entity.Member
import com.springboot.back.repository.BookRepository
import com.springboot.back.repository.MemberRepository
import com.springboot.client.dto.MemberDto
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
    @DisplayName("회원가입 테스트")
    fun member_sign (){
        //given
        val memberDto: MemberDto.MemberRequest = MemberDto.MemberRequest(
            member_id = 1L,
            member_email = "test@test.com",
            member_name = "홍길동",
            member_address = "경기도 부천시",
            member_password = "1234",
            member_phone = "010-1111-2222",
            member_registration = "981119-1185118"
        )

        val member: Member = Member(
            id = memberDto.member_id,
            email = memberDto.member_email,
            name = memberDto.member_name,
            address = memberDto.member_address,
            password = memberDto.member_password,
            phone = memberDto.member_phone,
            registration = memberDto.member_registration
        )

        //when
        val memberEntity: Member = memberRepository.save(member)
        println(memberEntity.toString()) // 회원 값 불어오기

        //then
        assertEquals(memberEntity.email,"test@test.com")
        assertEquals(memberEntity.name,"홍길동")
        assertEquals(memberEntity.password,"1234")
        assertEquals(memberEntity.address,"경기도 부천시")
        assertEquals(memberEntity.phone,"010-1111-2222")
        assertEquals(memberEntity.registration,"981119-1185118")
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