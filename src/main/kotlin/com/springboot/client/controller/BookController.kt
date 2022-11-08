package com.springboot.client.controller

import com.springboot.back.entity.Book
import com.springboot.client.dto.BookDto
import com.springboot.client.service.BookDtoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

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

        // 도서 상세 조회
        @GetMapping("/detail/{id}")
        fun booksDetail(@PathVariable id : Long): BookDto.BookResponse{

                return bookDtoService.booksDetail(id)
        }

        // 도서 수정하기
        @PutMapping("/edit/{id}")
        fun booksEdit(@PathVariable id: Long,
                      @RequestBody bookRequest: BookDto.BookRequest): Optional<Book> {

                return bookDtoService.boardUpdate(id, bookRequest)

        }

        // 도서 삭제하기
        @DeleteMapping("/delete/{id}")
        fun booksDelete(@PathVariable id: Long){
              bookDtoService.bookDelete(id)
        }



}


