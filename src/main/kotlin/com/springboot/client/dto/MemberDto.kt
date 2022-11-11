package com.springboot.client.dto

import io.swagger.annotations.ApiModelProperty

class MemberDto {

    class MemberRequest(

        @ApiModelProperty(name = "member_id", example = "", required = true)
        val member_id: Long?= null,

        @ApiModelProperty(name = "member_email", example = "test@test.com", required = true)
        val member_email: String,

        @ApiModelProperty(name = "member_name", example = "홍길동", required = true)
        val member_name: String,

        @ApiModelProperty(name = "member_password", example = "12345", required = true)
        val member_password: String,

        @ApiModelProperty(name = "member_address", example = "경기도 부천시", required = true)
        val member_address: String,

        @ApiModelProperty(name = "member_phone", example = "010-1111-2222", required = true)
        val member_phone: String,

        @ApiModelProperty(name = "member_registration", example = "981119-1185118", required = true)
        val member_registration: String


    ){

    }
    class MemberResponse(

        @ApiModelProperty(name = "member_id", example = "", required = true)
        val member_id: Long?= null,

        @ApiModelProperty(name = "member_email", example = "test@test.com", required = true)
        val member_email: String,

        @ApiModelProperty(name = "member_name", example = "홍길동", required = true)
        val member_name: String,

        @ApiModelProperty(name = "member_password", example = "12345", required = true)
        val member_password: String,

        @ApiModelProperty(name = "member_address", example = "경기도 부천시", required = true)
        val member_address: String,

        @ApiModelProperty(name = "member_phone", example = "010-1111-2222", required = true)
        val member_phone: String,

        @ApiModelProperty(name = "member_registration", example = "981119-1185118", required = true)
        val member_registration: String
    ){

    }
}