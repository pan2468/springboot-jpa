package com.springboot.back.entity

import lombok.Getter
import lombok.Setter
import lombok.ToString
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "books")
@Getter @Setter
@ToString
data class Book (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long ?= null,

    val title: String,

    val book_name: String,

    val content: String,

    val createdDate : LocalDateTime

    ){

}