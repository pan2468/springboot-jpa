package com.springboot.back.entity

import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.persistence.*

@Entity
@Table(name = "reservations")
@Getter @Setter
@ToString
data class Reservation( // 예약

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    val id: Long ?= null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member ?= null

    ): BaseEntity() {

    }