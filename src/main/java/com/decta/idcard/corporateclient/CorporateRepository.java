package com.decta.idcard.corporateclient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorporateRepository extends CrudRepository<CorporateEntity, Long> {

    List<CorporateEntity> findClientByCompanyRegistrationNumber(String companyRegistrationNumber);
}
