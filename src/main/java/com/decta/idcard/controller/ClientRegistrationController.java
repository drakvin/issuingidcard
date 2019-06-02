package com.decta.idcard.controller;

import com.decta.idcard.address.AddressDTO;
import com.decta.idcard.client.ClientDTO;
import com.decta.idcard.corporateclient.EnterpriseDTO;
import com.decta.idcard.idcardnumber.IdCardNumberDTO;
import com.decta.idcard.idcardnumber.IdCardNumberEntity;
import com.decta.idcard.service.ClientRegistrationService;
import com.decta.idcard.status.StatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequestMapping("/app")
public class ClientRegistrationController {

    private ClientRegistrationService clientRegistrationService;

    @Autowired
    public ClientRegistrationController(ClientRegistrationService clientRegistrationService) {
        this.clientRegistrationService = clientRegistrationService;
    }


    @PostMapping("/corporate")
    public StatusDTO registerCorporateClient(@RequestBody EnterpriseDTO corporate) {
        return clientRegistrationService.registerCorporateClient(corporate);
    }

    @PostMapping("/private")
    public StatusDTO registerPrivateClient(@RequestBody ClientDTO client, IdCardNumberDTO idCard, AddressDTO addressDTO) {
        return clientRegistrationService.registerPrivateClient(client, idCard, addressDTO);
    }


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    void handleIllegalArgument() {
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(IllegalStateException.class)
    void handleIllegalState() {
    }
}