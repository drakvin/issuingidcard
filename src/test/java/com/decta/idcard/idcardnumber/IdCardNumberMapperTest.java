package com.decta.idcard.idcardnumber;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class IdCardNumberMapperTest {

    @Test
    public void idCardNumberDTOToEntity() {

        IdCardNumberDTO idCardNumberDTO = new IdCardNumberDTO();
        idCardNumberDTO.setIdCardNumber("180486LV");

        IdCardNumberMapper idCardNumberMapper = new IdCardNumberMapper();
        IdCardNumberEntity actualIdCardEntity = idCardNumberMapper.idCardNumberDTOToEntity(idCardNumberDTO);

        assertTrue(actualIdCardEntity.getIdCardNumber().equals("180486LV"));
    }
}