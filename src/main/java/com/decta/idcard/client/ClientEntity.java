package com.decta.idcard.client;

import com.decta.idcard.address.AddressEntity;
import com.decta.idcard.idcardnumber.IdCardNumberEntity;

import javax.persistence.*;

@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    private IdCardNumberEntity idCardNumberEntity;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity addressEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public IdCardNumberEntity getIdCardNumberEntity() {
        return idCardNumberEntity;
    }

    public void setIdCardNumberEntity(IdCardNumberEntity idCardNumberEntity) {
        this.idCardNumberEntity = idCardNumberEntity;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
