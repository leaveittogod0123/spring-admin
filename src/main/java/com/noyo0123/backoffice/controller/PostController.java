package com.noyo0123.backoffice.controller;

import com.noyo0123.backoffice.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

//    @RequestMapping(method = RequestMethod.POST, path = "/postMethod") 아래랑 같은 기능
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        // @RequestBody는 http body위치에 데이터를 매핑하기 위한
        // PostMapping의 produces를 통해 전달해주는 데이터 타입을 정할 수 있음
        return searchParam;
    }
}
