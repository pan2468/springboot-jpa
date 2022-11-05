package com.springboot.client.dto

import io.swagger.annotations.ApiModelProperty

class BookDto {

    class BookRequest(
        @ApiModelProperty(name = "")
        val id : Long?= null,

        @ApiModelProperty(name = "")
        val title: String,

        @ApiModelProperty("")
        val book_name: String,

        @ApiModelProperty("")
        val content: String,

    ){


    }

    class BookResponse(

        @ApiModelProperty(name = "")
        val id : Long?= null,

        @ApiModelProperty(name = "")
        val book_title: String,

        @ApiModelProperty("")
        val book_name: String,

        @ApiModelProperty("")
        val book_content: String,
    ){


    }


}

