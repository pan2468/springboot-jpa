package com.springboot.client.controller

import com.springboot.client.dto.BookDto
import com.springboot.client.service.BookDtoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController @Autowired constructor (
        val bookDtoService: BookDtoService

        ){

        // 도서 상품 등록
        @PostMapping("/save")
        fun booksSave(@RequestBody bookRequest: BookDto.BookRequest): BookDto.BookResponse {
             val bookList = bookDtoService.booksSave(bookRequest)

             val bookResponse: BookDto.BookResponse = BookDto.BookResponse(
                     book_title = bookList.title,
                     book_name = bookList.book_name,
                     book_content = bookList.content
             )

             return bookResponse
        }

}