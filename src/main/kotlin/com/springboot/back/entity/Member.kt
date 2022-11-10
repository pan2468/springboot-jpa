package com.springboot.back.entity

import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.persistence.*

@Entity
@Table(name = "members")
@Getter @Setter
@ToString
data class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long ?= null,

    @Column(name = "member_name", nullable = false, length = 255)
    val name: String, // 회원이름

    @Column(name = "password", nullable = false)
    val password: String, // 비밀번호

    @Column(name = "address", length = 300)
    val address: String ?= null,

    @Column(name = "registration_number", nullable = false, length = 300)
    val registration: String ?= null

) : BaseEntity(){



}