package com.decta.idcard.idcardnumber;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdCardRepository extends CrudRepository<IdCardNumberEntity, Long> {

   IdCardNumberEntity findClientByIdCardNumber(String idCardNumber);


}