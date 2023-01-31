package com.stage.wael.services;

import com.stage.wael.entities.Client;

import java.util.List;

public interface IClientService {
    List<Client> retrieveAllClient();

    Client addClient(Client c);

    void deleteClient(Client c);

    Client retrieveClient (Long id);

    Client updateClient(Client c);


}
