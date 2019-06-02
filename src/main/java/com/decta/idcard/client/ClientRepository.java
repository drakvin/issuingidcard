package com.decta.idcard.client;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    ClientEntity findClientBySurname(String surname);
}
