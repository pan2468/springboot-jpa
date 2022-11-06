package com.springboot.back.entity

import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@EntityListeners(value = [AuditingEntityListener::class])
@MappedSuperclass
@Getter @Setter
abstract class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    var regTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    var updateTime: LocalDateTime = LocalDateTime.now()

}