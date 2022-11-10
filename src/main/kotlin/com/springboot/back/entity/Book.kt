package com.springboot.back.entity

import lombok.Getter
import lombok.Setter
import lombok.ToString
import javax.persistence.*

@Entity
@Table(name = "books")
@Getter @Setter
@ToString
data class Book (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long ?= null,

    @Column(name = "book_title", nullable = false, length = 300)
    var title: String,

    @Column(name = "book_name", nullable = false, length = 250)
    var book_name: String,

    @Column(name = "content", length = 250)
    var content: String,

    ) : BaseEntity() {

    fun updateBook(title: String, book_name: String, content: String){
         this.title = title
         this.book_name = book_name
         this.content = content
    }

}