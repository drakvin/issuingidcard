package com.decta.idcard.client;

import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientEntity clientDTOToEntity(ClientDTO client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(client.getName());
        clientEntity.setSurname(client.getSurname());
        return clientEntity;
    }
}