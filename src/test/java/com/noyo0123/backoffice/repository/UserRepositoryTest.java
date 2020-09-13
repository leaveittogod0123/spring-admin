package com.noyo0123.backoffice.repository;

import com.noyo0123.backoffice.BackofficeApplicationTests;
import com.noyo0123.backoffice.model.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends BackofficeApplicationTests { // 자동으로 생성된 테스트 클래스를 상속

    @Autowired
    private UserRepository userRepository; // 테스트할 repository 클래스

    @Test
    public void create() {
        User user = new User();
        user.setAccount("noyo0124");
        user.setEmail("noyo0124@gmail.com");
        user.setMobile("01012341234");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("noyo0124");

        User newUser =  userRepository.save(user);
        System.out.println("newUser: "+ newUser);
    }

    public void read() {

    }

    public void update(){

    }

    public void delete() {

    }
}
