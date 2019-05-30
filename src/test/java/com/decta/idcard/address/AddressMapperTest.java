package com.decta.idcard.address;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class AddressMapperTest {

    @Test
    public void addressDTOToEntity() {

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCountry("Latvia");
        addressDTO.setCity("Riga");
        addressDTO.setStreet("Maskavas");
        addressDTO.setBuildingNumber(1L);

        AddressMapper addressMapper = new AddressMapper();
        AddressEntity actualAddressEntity = addressMapper.addressDTOToEntity(addressDTO);

        assertTrue(actualAddressEntity.getCountry().equals("Latvia"));
        assertTrue(actualAddressEntity.getCity().equals("Riga"));
        assertTrue(actualAddressEntity.getStreet().equals("Maskavas"));
        assertTrue(actualAddressEntity.getBuildingNumber().equals(1L));
    }
}