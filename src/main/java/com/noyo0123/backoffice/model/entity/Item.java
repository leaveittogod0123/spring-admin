package com.noyo0123.backoffice.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data // get, set
@AllArgsConstructor // 인자 있는 생성자
@NoArgsConstructor // 인자 없는 생성자
@Entity //테이블
@ToString(exclude = {"orderDetailList", "partner"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Item {

    @Id // 유일키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql auto-increment
    private Long id;

    private String name;

    private Integer price;

    private String content;

    private String status;

    private String title;

    private String brandName;

    private LocalDateTime registeredAt;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

    // Item N : 1 Partner
    @ManyToOne
    private Partner partner;

    // 1: N 아이템입장에서 아이템이 1 주문내역이 N인 관계이니까!


    // LAZY 타입은 지연로딩!  EAGER = 즉시로딩!

    // LAZY = SELECT * FROM item where id = ? -> orderDetail에 컬럼을 get하지 않으면 연관관계에 매핑된 테이블에 대해서 셀렉트하지 않겠다!

    // EAGER =
    // on item0_.id=orderdetai1_.item_id
    // on orderdetai1_.user_id=user2_.id
    // where item_id = ?
    // from item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id where item0_.id=?
    // 연관관계의 테이블을 조인해서 모든 결과를 갖고와서 where문으로 나눠서 주겠다! -> 데이터가 많은 테이블에 Eager가 걸려있으면 한가지 item만 셀렉트하더라도! 모든 데이터를 조인해서 갖고 오기 때문에 성능상 불리하다.

    // 1:1 또는 manytoone의 경우만 Eager를 해달라~
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
