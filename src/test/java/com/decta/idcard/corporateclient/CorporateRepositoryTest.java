package com.decta.idcard.corporateclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CorporateRepositoryTest {

    @Autowired
    private CorporateRepository corporateRepository;

    @Test
    public void shouldSaveCorporateData(){

        CorporateEntity corporateEntity = new CorporateEntity();
        corporateEntity.setCompanyRegistrationNumber("180486VB");

        corporateRepository.save(corporateEntity);

        assertEquals(corporateRepository.count(), 1);
    }

}