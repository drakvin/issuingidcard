package com.decta.idcard.service;

import com.decta.idcard.address.AddressDTO;
import com.decta.idcard.address.AddressEntity;
import com.decta.idcard.address.AddressMapper;
import com.decta.idcard.address.AddressRepository;
import com.decta.idcard.corporateclient.CorporateEntity;
import com.decta.idcard.corporateclient.CorporateMapper;
import com.decta.idcard.corporateclient.CorporateRepository;
import com.decta.idcard.corporateclient.EnterpriseDTO;
import com.decta.idcard.idcardnumber.IdCardNumberDTO;
import com.decta.idcard.idcardnumber.IdCardNumberEntity;
import com.decta.idcard.idcardnumber.IdCardNumberMapper;
import com.decta.idcard.idcardnumber.IdCardRepository;
import com.decta.idcard.status.Status;
import com.decta.idcard.status.StatusDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientRegistrationService {

    private final IdCardRepository idCardRepository;
    private final CorporateRepository corporateRepository;
    private final AddressRepository addressRepository;
    private final IdCardNumberMapper idCardNumberMapper;
    private final AddressMapper addressMapper;
    private final CorporateMapper corporateMapper;

    public ClientRegistrationService(IdCardRepository idCardRepository,
                                     CorporateRepository corporateRepository,
                                     AddressRepository addressRepository,
                                     IdCardNumberMapper idCardNumberMapper,
                                     AddressMapper addressMapper,
                                     CorporateMapper corporateMapper) {
        this.idCardRepository = idCardRepository;
        this.corporateRepository = corporateRepository;
        this.addressRepository = addressRepository;
        this.idCardNumberMapper = idCardNumberMapper;
        this.addressMapper = addressMapper;
        this.corporateMapper = corporateMapper;
    }

    public StatusDTO registerPrivateClient(IdCardNumberDTO idCardNumberDTO, AddressDTO addressDTO) {
        IdCardNumberEntity idCard = idCardNumberMapper.idCardNumberDTOToEntity(idCardNumberDTO);
        AddressEntity address = addressMapper.addressDTOToEntity(addressDTO);
        idCardRepository.save(idCard);
        addressRepository.save(address);

        return getSuccessStatus();
    }

    public StatusDTO registerCorporateClient(EnterpriseDTO enterprise) {
        CorporateEntity corporate = corporateMapper.corporateDTOToEntity(enterprise);
        corporateRepository.save(corporate);

        return getSuccessStatus();
    }

    public List<IdCardNumberEntity> findClientByIdCard(String idCardNumber) {
        return idCardRepository.findClientByIdCardNumber(idCardNumber);
    }

    private static StatusDTO getSuccessStatus() {
        StatusDTO successResolution = new StatusDTO();
        successResolution.setStatus(Status.VALID);
        return successResolution;
    }
}