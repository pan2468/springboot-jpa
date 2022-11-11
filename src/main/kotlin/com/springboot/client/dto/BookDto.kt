package com.springboot.client.dto

import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

class BookDto {

    class BookRequest(

        @ApiModelProperty(name = "도서 번호", value = "제목 입니다.", required = true)
        val id: Long,

        @ApiModelProperty(name = "도서 제목", value = "제목 입니다.", required = true)
        val title: String,

        @ApiModelProperty(name = "도서명", value = "책 잘 읽습니다.", required = true)
        val book_name: String,

        @ApiModelProperty(name = "도서 내용" , value = "내용 입력", required = true)
        val content: String,

    ){

    }

    class BookResponse(

        @ApiModelProperty(name = "번호")
        var id: Long?,

        @ApiModelProperty(name = "도서 제목", value = "제목 받기.", required = true)
        var book_title: String,

        @ApiModelProperty(name = "도서명", value = "도서명 받기", required = true)
        var book_name: String,

        @ApiModelProperty(name = "도서 내용" , value = "내용 받기", required = true)
        var book_content: String,

    ){

    }
}

