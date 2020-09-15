package com.noyo0123.backoffice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data // get, set
@AllArgsConstructor // 인자 있는 생성자
@NoArgsConstructor // 인자 없는 생성자
@Entity //테이블
public class Item {

    @Id // 유일키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql auto-increment
    private Long id;

    private String name;

    private Integer price;

    private String content;

    // 1: N 아이템입장에서 아이템이 1 주문내역이 N인 관계이니까!
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
