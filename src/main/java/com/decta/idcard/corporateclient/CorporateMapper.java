package com.decta.idcard.corporateclient;

import org.springframework.stereotype.Component;

@Component
public class CorporateMapper {
    public CorporateEntity corporateDTOToEntity(EnterpriseDTO enterpriseDTO) {
        CorporateEntity corporateEntity = new CorporateEntity();

        corporateEntity.setCompanyRegistrationNumber(enterpriseDTO.getCompanyRegistrationNumber());

        return corporateEntity;
    }
}