package com.noyo0123.backoffice.repository;

import com.noyo0123.backoffice.BackofficeApplicationTests;
import com.noyo0123.backoffice.model.entity.OrderDetail;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends BackofficeApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");

        orderDetail.setOrderGroupId(1L);        //어떤 장바구니에
        orderDetail.setItemId(1L);        //어떤 아이템을



         OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

         Assert.assertNotNull(newOrderDetail);
    }

    @Test
    public void read() {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
        Assert.assertNotNull(orderDetail);
    }
}
