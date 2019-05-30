package com.decta.idcard.address;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressRepositoryTest {


    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void shouldSaveAddress() {

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry("Latvia");
        addressEntity.setCity("Riga");
        addressEntity.setStreet("Augusta Deglava");

        addressRepository.save(addressEntity);

        AddressEntity address = new AddressEntity();
        address.setCountry("Latvia");
        address.setCity("Riga");
        address.setStreet("Maskavas");

        addressRepository.save(address);

        assertEquals(addressRepository.count(), 2);

    }
}