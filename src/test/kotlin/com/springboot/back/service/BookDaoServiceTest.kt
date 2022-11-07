package com.springboot.back.service

import com.springboot.back.entity.Book
import com.springboot.back.repository.BookRepository
import com.springboot.client.dto.BookDto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.transaction.annotation.Transactional
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import java.util.*

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

    @Test
    @Transactional(readOnly = true)
    @DisplayName("도서 상세 조회")
    fun bookDetail(){
        //given
        this.bookReg()
        val id : Long = 1L

        //when
        val booksDetail: Optional<Book> = bookRepository.findById(id)

        val bookResponse: BookDto.BookResponse = BookDto.BookResponse(
            id = booksDetail.get().id,
            book_title = booksDetail.get().title,
            book_name = booksDetail.get().book_name,
            book_content = booksDetail.get().content
        )

        //then
        println(bookResponse.book_name.toString()) // 상세조회 값 확인하기

        assertEquals(bookResponse.id,1)
        assertEquals(bookResponse.book_title,"제목")
        assertEquals(bookResponse.book_name,"도서명")
        assertEquals(bookResponse.book_content,"내용")

    }


    @Test
    @Transactional
    @DisplayName("도서 수정하기")
    fun bookUpdate(){
        //given
        this.bookReg()

        //when
        val findById: Optional<Book> = bookRepository.findById(1L)
        val bookUpdate: Book = findById.get()

       bookUpdate.updateBook(
            title = "제목입니다",
            book_name = "책을 읽자",
            content = "안녕하세요"
        )

        val update: Book = bookRepository.save(bookUpdate)

        //then
        println(update.toString())

        assertEquals(update.title,"제목입니다")
        assertEquals(update.book_name, "책을 읽자")
        assertEquals(update.content, "안녕하세요")
    }




}


