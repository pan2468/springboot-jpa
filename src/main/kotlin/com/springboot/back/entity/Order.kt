package com.springboot.back.entity

import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.persistence.*

@Entity
@Table(name = "orders")
@Getter @Setter
@ToString
data class Order(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    val id: Long ?= null,

    @Column(name = "price", nullable = false)
    val price: Int ?= 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member ?= null

    ): BaseEntity() {

    }