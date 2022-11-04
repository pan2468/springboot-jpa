package com.springboot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig() {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any()) //Swagger API 문서로 만들기 원하는 basePackage 경로
            .paths(PathSelectors.ant("/*/**")) //URL 경로를 지정하여 해당 URL에 해당하는 요청만 SWAGGER로 만듦
            .build()
    }

    private val consumeContentTypes: Set<String>
        private get() {
            val consumes: MutableSet<String> = HashSet()
            consumes.add("application/json;charset=UTF-8")
            consumes.add("application/x-www-form-urlencoded")
            return consumes
        }
    private val produceContentTypes: Set<String>
        private get() {
            val produces: MutableSet<String> = HashSet()
            produces.add("application/json;charset=UTF-8")
            return produces
        }
    private val apiInfo: ApiInfo
        private get() = ApiInfoBuilder()
            .title("API")
            .description("SpringBoot With Swagger")
            .contact(Contact("SpringBoot with Swagger", "https://github.com/pan2468", "pan1129@naver.com"))
            .version("1.0")
            .build()
}