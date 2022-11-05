package com.springboot.client.service

import com.springboot.back.entity.Book
import com.springboot.back.service.BookDaoService
import com.springboot.client.dto.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseBody

@Service
class BookDtoService @Autowired constructor (
        val bookDaoService: BookDaoService

        ){

        // 도서 상품 등록
        fun booksSave(bookRequest: BookDto.BookRequest) : Book {
            return bookDaoService.booksSave(bookRequest)
        }

}