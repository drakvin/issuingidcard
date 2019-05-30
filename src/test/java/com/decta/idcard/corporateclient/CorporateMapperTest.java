package com.decta.idcard.corporateclient;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CorporateMapperTest {

    @Test
    public void corporateDTOToEntity() {
        EnterpriseDTO enterpriseDTO = new EnterpriseDTO();

        enterpriseDTO.setCompanyRegistrationNumber("LV1414NUMBER");

        CorporateMapper corporateMapper = new CorporateMapper();
        CorporateEntity actualCorporateEntity = corporateMapper.corporateDTOToEntity(enterpriseDTO);


        assertTrue(actualCorporateEntity.getCompanyRegistrationNumber().equals("LV1414NUMBER"));

    }
}