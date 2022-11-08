package com.springboot.back.service

import com.springboot.back.entity.Book
import com.springboot.back.repository.BookRepository
import com.springboot.client.dto.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class BookDaoService @Autowired constructor (
           val bookRepository: BookRepository

        ){

        // 도서 상품 등록
        @Transactional
        fun booksSave(bookRequest: BookDto.BookRequest) : Book {

            val save : Book = Book(
                title = bookRequest.title,
                book_name = bookRequest.book_name,
                content = bookRequest.content,

            ).run {
               return bookRepository.save(this)
            }
        }

    @Transactional(readOnly = true)
    fun booksList(): List<Book> {

        val booksList:List<Book> = bookRepository.findAll()

        return booksList
    }

    @Transactional(readOnly = true)
    fun booksDetail(id: Long): Optional<Book> {
        val booksDetail:Optional<Book> = bookRepository.findById(id)

        return booksDetail
    }


    fun booksEdit(id: Long): Optional<Book> {
        return bookRepository.findById(id)
    }


    fun boardUpdate(title: String, book_name: String, content: String): Book {

        val edit: Book = Book(
            title = title,
            book_name = book_name,
            content = content
        )

        val update: Book = bookRepository.save(edit)

        return update
    }
}