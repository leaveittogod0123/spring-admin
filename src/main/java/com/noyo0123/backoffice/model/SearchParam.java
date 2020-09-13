package com.noyo0123.backoffice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 모든 매개변수를 갖는 생성자 메서드를 만들어줌
public class SearchParam {

    private String account;
    private String email;
    private int page;

}
