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
    fun bookReg (){
        //given
        val bookRequest: BookDto.BookRequest = BookDto.BookRequest(
            title = "제목",
            book_name = "도서명",
            content = "내용"
        )

        //when
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
            id = book.id,
            book_title = book.title,
            book_name = book.book_name,
            book_content = book.content
        )

        assertEquals(bookResponse.id, 1)
        assertEquals(bookResponse.book_title, "제목")
        assertEquals(bookResponse.book_name, "도서명")
        assertEquals(bookResponse.book_content, "내용")

    }


}


