package com.decta.idcard.idcardnumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IdCardRepositoryTest {

    @Autowired
    private IdCardRepository idCardRepository;

    @Test
    public void shouldSaveIdCardNumber() {

        IdCardNumberEntity idCard = new IdCardNumberEntity();
        idCard.setIdCardNumber("LV11448");

        idCardRepository.save(idCard);

        IdCardNumberEntity idCardOne = new IdCardNumberEntity();
        idCardOne.setIdCardNumber("LV200686");

        idCardRepository.save(idCardOne);


        IdCardNumberEntity idCardTwo = new IdCardNumberEntity();
        idCardTwo.setIdCardNumber("KB121215");
        idCardRepository.save(idCardTwo);

        assertEquals(idCardRepository.count(), 3);
    }
}