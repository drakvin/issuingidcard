package com.decta.idcard.client;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientMapperTest {

    @Test
    public void clientDTOToEntity() {

        ClientDTO client = new ClientDTO();

        client.setName("Foo");
        client.setSurname("Bar");

        ClientMapper clientMapper = new ClientMapper();
        ClientEntity actualEntity = clientMapper.clientDTOToEntity(client);

        assertTrue(actualEntity.getName().equals("Foo"));
        assertTrue(actualEntity.getSurname().equals("Bar"));
    }
}