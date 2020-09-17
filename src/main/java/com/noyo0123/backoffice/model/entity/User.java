package com.noyo0123.backoffice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data // get set
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자 만들어주는 메서드 에러가 나서 넣어줌.
@Entity // === TBL
public class User { // TBL의 이름과 동일하게

    @Id // 식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 식별자 어떤전략으로 만들건지? mysql - autoincrement - identity
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private String registeredBy;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // User 입장에서는 1 : orderDetail이 N!
    // LAZY 타입은 지연로딩!  EAGER = 즉시로딩!

    // LAZY = SELECT * FROM item where id = ?
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // fetch타입 왜 lazy? 어떤 컬럼과 매핑할건지 mappedBy user는 OrderDetail의 user과 동일해야함.
//    private List<OrderDetail> orderDetailList;
}
