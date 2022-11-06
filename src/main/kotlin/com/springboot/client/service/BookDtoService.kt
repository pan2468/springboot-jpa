package com.springboot.client.service

import com.springboot.back.entity.Book
import com.springboot.back.service.BookDaoService
import com.springboot.client.dto.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class BookDtoService @Autowired constructor (
        val bookDaoService: BookDaoService

        ){

        // 도서 상품 등록
        fun booksSave(bookRequest: BookDto.BookRequest) : Book {
            return bookDaoService.booksSave(bookRequest)
        }

        fun booksList() : BookDto.BookResponse {
                val booksList: List<Book> = bookDaoService.booksList()

                val bookResponse: BookDto.BookResponse = BookDto.BookResponse(
                        id = booksList.get(0).id,
                        book_title = booksList.get(0).title,
                        book_name = booksList.get(0).book_name,
                        book_content = booksList.get(0).content
                )

                return bookResponse
        }

        fun booksDetail(id: Long): BookDto.BookResponse {
                val booksDetail: Optional<Book> = bookDaoService.booksDetail(id)

                val bookResponse: BookDto.BookResponse = BookDto.BookResponse(
                        id = booksDetail.get().id,
                        book_title = booksDetail.get().title,
                        book_name = booksDetail.get().book_name,
                        book_content = booksDetail.get().content
                )

                return bookResponse
        }

}