package com.springboot.back.service

import com.springboot.back.entity.Book
import com.springboot.back.repository.BookRepository
import com.springboot.client.dto.BookDto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@TestPropertySource(locations = ["classpath:application.properties"])
@ActiveProfiles("test")
class BookDaoServiceTest @Autowired constructor(

    val bookRepository: BookRepository,
){

    @Test
    @Transactional
    @DisplayName("도서 상품 등록")
    fun book_reg (){
        //given
        val title  = "제목"
        val name = "도서명"
        val content = "내용"

        //when
        val bookRequest: BookDto.BookRequest = BookDto.BookRequest(
            title = "제목",
            book_name = "도서명",
            content = "내용"
        )

        val book: Book = Book(
            title = bookRequest.title,
            book_name = bookRequest.book_name,
            content = bookRequest.content,
            createdDate = LocalDateTime.now()
        )
        bookRepository.save(book)
        println(book.toString())

        //then
        val bookResponse: BookDto.BookResponse = BookDto.BookResponse(
            book_title = book.title,
            book_name = book.book_name,
            book_content = book.content
        )

        assertEquals(bookResponse.book_title, title)
        assertEquals(bookResponse.book_name, name)
        assertEquals(bookResponse.book_content, content)

    }
}


