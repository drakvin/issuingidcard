package com.decta.idcard.address;

import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressEntity addressDTOToEntity(AddressDTO addressDTO) {
        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setCountry(addressDTO.getCountry());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setStreet(addressDTO.getStreet());
        addressEntity.setBuildingNumber(addressDTO.getBuildingNumber());

        return addressEntity;
    }
}