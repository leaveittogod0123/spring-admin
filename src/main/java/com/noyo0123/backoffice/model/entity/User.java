package com.noyo0123.backoffice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data // get set
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자 만들어주는 메서드 에러가 나서 넣어줌.
@Entity // === TBL
public class User { // TBL의 이름과 동일하게

    @Id // 식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 식별자 어떤전략으로 만들건지? mysql - autoincrement - identity
    private Long id;

    private String account;

    private String email;

    private String mobile;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
