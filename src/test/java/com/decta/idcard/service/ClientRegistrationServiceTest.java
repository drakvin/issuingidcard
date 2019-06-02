package com.decta.idcard.service;

import com.decta.idcard.address.AddressDTO;
import com.decta.idcard.address.AddressEntity;
import com.decta.idcard.address.AddressRepository;
import com.decta.idcard.client.ClientDTO;
import com.decta.idcard.corporateclient.CorporateEntity;
import com.decta.idcard.corporateclient.CorporateMapper;
import com.decta.idcard.corporateclient.CorporateRepository;
import com.decta.idcard.corporateclient.EnterpriseDTO;
import com.decta.idcard.idcardnumber.IdCardNumberDTO;
import com.decta.idcard.idcardnumber.IdCardNumberEntity;
import com.decta.idcard.idcardnumber.IdCardNumberMapper;
import com.decta.idcard.idcardnumber.IdCardRepository;
import com.decta.idcard.status.StatusDTO;
import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRegistrationServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private IdCardRepository idCardRepository;

    @Mock
    private CorporateRepository corporateRepository;

    @Autowired
    ClientRegistrationService clientRegistrationService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfPrivateClientExist() {

        ClientDTO client = new ClientDTO();
        IdCardNumberDTO idCard = new IdCardNumberDTO();
        AddressDTO address = new AddressDTO();

        address.setCity("Riga");
        address.setStreet("Ogres");
        address.setBuildingNumber(10L);

        idCard.setIdCardNumber("007JB");

        client.setSurname("Ivanovs");

        clientRegistrationService.registerPrivateClient(client, idCard, address);
        clientRegistrationService.registerPrivateClient(client, idCard, address);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfCorporateClientExist() {

        EnterpriseDTO enterpriseDTO = new EnterpriseDTO();
        enterpriseDTO.setCompanyRegistrationNumber("LV1414NUMBER");

        clientRegistrationService.registerCorporateClient(enterpriseDTO);
        clientRegistrationService.registerCorporateClient(enterpriseDTO);
    }

    @Test
    public void shouldRegisterPrivateClientSuccessful() {
        IdCardNumberEntity idCardNumber = new IdCardNumberEntity();
        idCardNumber.setId(1L);
        idCardNumber.setIdCardNumber("Number1");
        idCardRepository.save(idCardNumber);

        AddressEntity address = new AddressEntity();
        address.setId(1L);
        address.setCountry("Latvia");
        address.setCity("Riga");
        address.setStreet("Brivibas");
        address.setBuildingNumber(215L);
        addressRepository.save(address);

        Assert.assertNotNull(idCardRepository);
        Assert.assertNotNull(addressRepository);
    }

    @Test
    public void shouldRegisterCorporateClientSuccessful() {

        CorporateEntity corporateEntity = new CorporateEntity();
        corporateEntity.setId(1L);
        corporateEntity.setCompanyRegistrationNumber("Number1");

        corporateRepository.save(corporateEntity);

        Assert.assertNotNull(corporateRepository);
    }

}