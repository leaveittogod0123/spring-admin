package com.noyo0123.backoffice.model.network.response;

import com.noyo0123.backoffice.model.enumClass.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemApiResponse {
    private Long id;

    // 상품 상태
    private ItemStatus status;

    // 이름
    private String name;

    // 타이틀
    private String title;

    // 내용
    private String content;

    // 가격
    private BigDecimal price;

    // 브랜드
    private String brandName;

    // 등록일자
    private LocalDateTime registeredAt;

    // 내린일자
    private LocalDateTime unregisteredAt;

    // 어떤 파트너사의 상품인지
    private Long partnerId;
}
