package com.decta.idcard.service;

import com.decta.idcard.address.AddressDTO;
import com.decta.idcard.address.AddressMapper;
import com.decta.idcard.address.AddressRepository;
import com.decta.idcard.client.ClientDTO;
import com.decta.idcard.client.ClientEntity;
import com.decta.idcard.client.ClientMapper;
import com.decta.idcard.client.ClientRepository;
import com.decta.idcard.corporateclient.CorporateEntity;
import com.decta.idcard.corporateclient.CorporateMapper;
import com.decta.idcard.corporateclient.CorporateRepository;
import com.decta.idcard.corporateclient.EnterpriseDTO;
import com.decta.idcard.idcardnumber.IdCardNumberDTO;
import com.decta.idcard.idcardnumber.IdCardNumberMapper;
import com.decta.idcard.idcardnumber.IdCardRepository;
import com.decta.idcard.status.Status;
import com.decta.idcard.status.StatusDTO;
import org.springframework.stereotype.Service;

@Service
public class ClientRegistrationService {

    private final IdCardRepository idCardRepository;
    private final CorporateRepository corporateRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final ClientMapper clientMapper;
    private final IdCardNumberMapper idCardNumberMapper;
    private final AddressMapper addressMapper;
    private final CorporateMapper corporateMapper;

    public ClientRegistrationService(IdCardRepository idCardRepository,

                                     CorporateRepository corporateRepository,
                                     ClientRepository clientRepository,
                                     AddressRepository addressRepository,
                                     ClientMapper clientMapper,
                                     IdCardNumberMapper idCardNumberMapper,
                                     AddressMapper addressMapper,
                                     CorporateMapper corporateMapper) {
        this.idCardRepository = idCardRepository;
        this.corporateRepository = corporateRepository;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.clientMapper = clientMapper;
        this.idCardNumberMapper = idCardNumberMapper;
        this.addressMapper = addressMapper;
        this.corporateMapper = corporateMapper;
    }


    public StatusDTO registerPrivateClient(ClientDTO clientDTO, IdCardNumberDTO idCardNumberDTO, AddressDTO addressDTO){
        String surname = clientDTO.getSurname();

        if (clientRepository.findClientBySurname(surname) != null) {
            throw new IllegalArgumentException();
        } else {
            ClientEntity clientEntity = clientMapper.clientDTOToEntity(clientDTO, addressDTO, idCardNumberDTO);

            clientRepository.save(clientEntity);
        }

        return getSuccessStatus();
    }

    public StatusDTO registerCorporateClient(EnterpriseDTO enterprise){

        String companyRegistrationNumber = enterprise.getCompanyRegistrationNumber();

        if (corporateRepository.findClientByCompanyRegistrationNumber(companyRegistrationNumber) != null) {
            throw new IllegalArgumentException();
        } else {
            CorporateEntity corporateEntity = new CorporateEntity();
            corporateEntity.setCompanyRegistrationNumber(companyRegistrationNumber);

            corporateRepository.save(corporateEntity);
        }
        return getSuccessStatus();
    }


    private static StatusDTO getSuccessStatus() {
        StatusDTO successResolution = new StatusDTO();
        successResolution.setStatus(Status.VALID);
        return successResolution;
    }
}