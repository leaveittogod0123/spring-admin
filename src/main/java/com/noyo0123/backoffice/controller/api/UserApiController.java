package com.noyo0123.backoffice.controller.api;

import com.noyo0123.backoffice.controller.ifs.CrudInterface;
import com.noyo0123.backoffice.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {
    @Override
    @PostMapping("")
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}") // api/user/{id}
    public Header read(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("") // api/user
    public Header update() {
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
