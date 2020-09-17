package com.noyo0123.backoffice.repository;

import com.noyo0123.backoffice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    //QueryMethod! 쿼리문을 마치 메서드 형태로 작성한다!
//
//    // select * from user where account = ?
//    Optional<User> findByAccount(String account);// Optional : 유저는 있을수도 없을수도 있음.
//
//    Optional<User> findByEmail(String email); // 변수가 아니고 메서드 명으로 JPA가 컬럼과 매칭해줌
//
//    Optional<User> findByAccountAndEmail(String account, String email);

}
