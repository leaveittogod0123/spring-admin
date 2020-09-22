package com.noyo0123.backoffice.controller.api;

import com.noyo0123.backoffice.controller.ifs.CrudInterface;
import com.noyo0123.backoffice.model.entity.User;
import com.noyo0123.backoffice.model.network.Header;
import com.noyo0123.backoffice.model.network.request.UserApiRequest;
import com.noyo0123.backoffice.model.network.response.UserApiResponse;
import com.noyo0123.backoffice.service.UserApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {


    @Autowired
    private UserApiService userApiService;

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request); // request.toString() 처럼 나올것임 .
        return userApiService.create(request);
    }

    @Override
    @GetMapping("{id}") // api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        log.info("read id {}", id);
        return userApiService.read(id);
    }

    @Override
    @PutMapping("") // api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}") // api/user/{id}
    public Header delete(@PathVariable Long id) {
        return null;
    }

//    public Header create(){
//    }
//
//    public Header read(){
//
//    }
//
//    public Header update() {
//
//    }
//
//    public interface로~ 만들어서 사용합시다.
}
