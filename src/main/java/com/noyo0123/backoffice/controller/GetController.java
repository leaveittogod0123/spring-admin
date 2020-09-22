package com.noyo0123.backoffice.controller;

import com.noyo0123.backoffice.model.SearchParam;
import com.noyo0123.backoffice.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {
        return "Hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        System.out.println("id : " + id);
        System.out.println("pw : " + pwd);
        return id + pwd;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.printf(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // object 리턴하면 jackson을 통해 json으로 변환되어 응답 됌.
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){

        /**
         * { "resultCode" : "OK", "description": "OK" }
         */
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
