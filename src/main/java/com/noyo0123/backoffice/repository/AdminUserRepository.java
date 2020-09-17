package com.noyo0123.backoffice.repository;

import com.noyo0123.backoffice.model.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> { // 엔티티, PK 타입
}
