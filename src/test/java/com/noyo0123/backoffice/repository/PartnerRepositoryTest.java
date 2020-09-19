package com.noyo0123.backoffice.repository;

import com.noyo0123.backoffice.BackofficeApplicationTests;
import com.noyo0123.backoffice.model.entity.Partner;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends BackofficeApplicationTests {


    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create() {
        String name = "Partner01";
        String status = "Registerd";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123";
        String ceoName = "이영호";
        LocalDateTime registerdAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createBy = "AdminServer";

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setBusinessNumber(businessNumber);
        partner.setPartnerNumber(partnerNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registerdAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createBy);
        partner.setCategoryId(1L);

        Partner newPartner = partnerRepository.save(partner);

        Assert.assertNotNull(newPartner);
        Assert.assertEquals(newPartner.getName(), name);
    }

    @Test
    public void read() {

    }
}
