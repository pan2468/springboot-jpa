package com.springboot.back.entity

import lombok.Getter
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@EntityListeners(value = [AuditingEntityListener::class])
@MappedSuperclass
@Getter
abstract class BaseEntity : BaseTimeEntity() {

    @CreatedBy
    @Column(updatable = false)
    var createBy: String?=null

    @LastModifiedBy
    var modifiedBy: String?=null

}