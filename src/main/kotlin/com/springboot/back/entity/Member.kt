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
    @Column(name = "member_id")
    val id:Long ?= null,

    @Column(name = "email", nullable = false, length = 255)
    val email:String ?= null,

    @Column(name = "member_name", nullable = false, length = 255)
    val name: String, // 회원이름

    @Column(name = "member_password", nullable = false)
    val password: String, // 비밀번호

    @Column(name = "member_address", length = 300)
    val address: String ?= null, //주소

    @Column(name = "member_phone", length = 255)
    val phone: String ?= null,

    @Column(name = "member_registration", nullable = false, length = 300)
    val registration: String ?= null // 주민등록번호 입력

) : BaseEntity(){

//    @OneToMany(mappedBy = "member")
//    private val books: List<Book> = ArrayList<Book>()


}