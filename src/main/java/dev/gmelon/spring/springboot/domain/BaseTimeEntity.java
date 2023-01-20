package dev.gmelon.spring.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 이 클래스를 상속하는 엔티티가 현 클래스의 필드도 칼럼으로 인식하도록 설정
@EntityListeners(AuditingEntityListener.class) // Auditing 기능을 포함시킴
public abstract class BaseTimeEntity {

    @CreatedDate // 엔티티가 생성되어 저장될 때 시간이 자동으로 기록
    private LocalDateTime createdTime;

    @LastModifiedDate // 조회한 엔티티의 값을 변경할 때 시간이 자동으로 기록
    private LocalDateTime modifiedDate;

}
