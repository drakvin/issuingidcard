package com.decta.idcard.controller;

import com.decta.idcard.corporateclient.CorporateEntity;
import com.decta.idcard.idcardnumber.IdCardNumberEntity;
import com.decta.idcard.service.ClientRegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClientRegistrationControllerTest {


    @MockBean
    ClientRegistrationService clientRegistrationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registerCorporateClient() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/app/corporate")
                .content(asJsonString(new CorporateEntity()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void registerPrivateClient() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/app/private")
                .content(asJsonString(new IdCardNumberEntity()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}