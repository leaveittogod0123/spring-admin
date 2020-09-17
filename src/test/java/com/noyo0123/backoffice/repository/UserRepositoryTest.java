package com.noyo0123.backoffice.repository;

import com.noyo0123.backoffice.BackofficeApplicationTests;
import com.noyo0123.backoffice.model.entity.Item;
import com.noyo0123.backoffice.model.entity.User;
import org.apache.tomcat.jni.Local;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends BackofficeApplicationTests { // 자동으로 생성된 테스트 클래스를 상속

    @Autowired
    private UserRepository userRepository; // 테스트할 repository 클래스

    @Test // 테스트를 하기위해선 이 어노테이션을 붙여줘야해요.
    public void create() {
        User user = new User();
        user.setAccount("noyo0125");
        user.setEmail("noyo0125@gmail.com");
        user.setMobile("01012341235");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("noyo0125");

        User newUser =  userRepository.save(user);
        System.out.println("newUser: "+ newUser);
    }

    @Test
    @Transactional
    public void read() {
        Optional<User> user = userRepository.findByAccount("noyo0125"); // user ID가 long type이라
          user.ifPresent(selectUser ->{ // 존재하면 동작
            System.out.println("user: "+ selectUser);
            selectUser.getOrderDetailList().stream().forEach(detail -> {
//                System.out.println(detail.getItemId()); // 이거 JPA, lombok toString 에러 나기 때문에 OrderDetail 엔티티에서 @ToString(exclude = "user") 추가해줌 이유는 println때문임.
                Item item = detail.getItem();
                System.out.println(item);
            });
        });

    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> {
            // 나머지 컬럼에 대해서는 JPA가 다시 업데이트를 해줌. 결국 update시 모든 컬럼이 업데이트 됩니다. 기존값은 그대로 있고요.
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional // spring annotaion 테스트 후 데이터 롤백
    public void delete() {

        Optional<User> user = userRepository.findById(1L);


        Assert.assertTrue(user.isPresent()); // true


        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        Assert.assertFalse(deleteUser.isPresent()); // false

    }
}
