package com.noyo0123.backoffice.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderType {

    ALL(0, "묶음","모든 상품을 일괄발송"),
    EACH(1, "개별", "개별발송")
    ;

    private Integer id;
    private String title;
    private String description;
}
