package com.springboot.back.entity

import lombok.Getter
import lombok.Setter
import lombok.ToString
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "rentals")
@Getter @Setter
@ToString
data class Rental(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rentals_id")
    var id: Long ?= null,

    @Column(name = "rental_number", length = 255)
    val rental_number: Int ?= 0, // 대여권수

    @Column(name = "loan_date", nullable = false)
    val loan_date: LocalDateTime, // 대출일자

    @Column(name = "return_date", nullable = false)
    val return_date: LocalDateTime, // 반납일자

    @Column(name = "extensions_number", length = 255)
    val extensions_number: Int?= 0, // 연장횟수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private var member: Member? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private var book: Book? = null

) : BaseEntity() {



}