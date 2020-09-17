package com.noyo0123.backoffice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
//@ToString(exclude = {"user","item"})
@NoArgsConstructor
@Entity // order_detail
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // orderDetail 입장에서
    // orderDetail이 N, user가 1
    @ManyToOne
    private User user; // 이렇게 바뀝니다. Hibernate를 통한 연관관계 매핑시 반드시 객체! 매핑, hibernate가 알아서 user_id를 찾아감, 이제 User 클래스가서 관계 매칭
    //    private Long userId; 연관관계 매핑전

    @ManyToOne
    private Item item;

}
