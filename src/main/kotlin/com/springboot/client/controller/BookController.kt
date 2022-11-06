package com.springboot.client.controller

import com.springboot.client.dto.BookDto
import com.springboot.client.service.BookDtoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
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
        fun booksSave(@RequestBody bookRequest: BookDto.BookRequest) {
             val booksSave = bookDtoService.booksSave(bookRequest)

        }

        // 도서 목록 조회
        @GetMapping("/list")
        fun booksList(): BookDto.BookResponse {

            return bookDtoService.booksList()
        }


}