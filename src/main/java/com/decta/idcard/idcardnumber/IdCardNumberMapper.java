package com.decta.idcard.idcardnumber;

import org.springframework.stereotype.Component;

@Component
public class IdCardNumberMapper {


    public IdCardNumberEntity idCardNumberDTOToEntity(IdCardNumberDTO idCardNumberDTO) {
        IdCardNumberEntity idCardNumberEntity = new IdCardNumberEntity();

        idCardNumberEntity.setIdCardNumber(idCardNumberDTO.getIdCardNumber());

        return idCardNumberEntity;
    }
}