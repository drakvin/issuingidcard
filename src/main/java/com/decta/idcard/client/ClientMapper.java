package com.decta.idcard.client;

import com.decta.idcard.address.AddressDTO;
import com.decta.idcard.address.AddressEntity;
import com.decta.idcard.idcardnumber.IdCardNumberDTO;
import com.decta.idcard.idcardnumber.IdCardNumberEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientEntity clientDTOToEntity(ClientDTO client, AddressDTO addressDTO, IdCardNumberDTO idCardNumberDTO) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(client.getName());
        clientEntity.setSurname(client.getSurname());

        AddressEntity address = new AddressEntity();
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        IdCardNumberEntity idCard = new IdCardNumberEntity();
        idCard.setIdCardNumber(idCardNumberDTO.getIdCardNumber());

        clientEntity.setAddressEntity(address);
        clientEntity.setIdCardNumberEntity(idCard);

        return clientEntity;
    }

    public ClientEntity clientDTOToEntity(ClientDTO client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(client.getName());
        clientEntity.setSurname(client.getSurname());
        return clientEntity;
    }
}