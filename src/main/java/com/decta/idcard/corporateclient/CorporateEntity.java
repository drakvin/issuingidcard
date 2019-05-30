package com.decta.idcard.corporateclient;

import com.decta.idcard.address.AddressEntity;
import com.decta.idcard.idcardnumber.IdCardNumberEntity;

import javax.persistence.*;

@Entity
public class CorporateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String companyRegistrationNumber;

    @OneToOne
    private IdCardNumberEntity idCardNumberEntity;

    @OneToOne
    private AddressEntity addressEntity;



    public void setIdCardNumberEntity(IdCardNumberEntity idCardNumberEntity) {
        this.idCardNumberEntity = idCardNumberEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public IdCardNumberEntity getIdCardNumberEntity() {
        return idCardNumberEntity;
    }
}
