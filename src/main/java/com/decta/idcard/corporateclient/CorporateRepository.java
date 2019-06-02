package com.decta.idcard.corporateclient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateRepository extends CrudRepository<CorporateEntity, Long> {

    CorporateEntity findClientByCompanyRegistrationNumber(String companyRegistrationNumber);
}
