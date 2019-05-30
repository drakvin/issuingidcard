package com.decta.idcard.idcardnumber;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdCardRepository extends CrudRepository<IdCardNumberEntity, Long> {

    List<IdCardNumberEntity> findClientByIdCardNumber(String idCardNumber);


}