package com.example.jpa.board.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //Jpa Entity클래스들이 BaseTimeEntitiy을 상속할 경우 필드들도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class)// BaseTimeEntity클래스에 Auditing 기능을 포함한다.
public class BaseTimeEntity {

    @CreatedDate //Entitiy가 생성되어 저장될 때 시간이 자동 저장
    private LocalDateTime regDate;

    @LastModifiedDate//조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime updateDate;
}
