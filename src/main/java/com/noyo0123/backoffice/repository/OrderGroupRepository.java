package com.noyo0123.backoffice.repository;

import com.noyo0123.backoffice.model.entity.OrderGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGroupRepository extends JpaRepository<OrderGroup, Long> { // 엔티티, PK타입
}
