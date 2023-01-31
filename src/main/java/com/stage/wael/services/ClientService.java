package com.stage.wael.services;

import com.stage.wael.entities.Client;
import com.stage.wael.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ClientService implements IClientService {

   @Autowired
    ClientRepository clientRepo;


    @Override
    public List<Client> retrieveAllClient() {
        return (List<Client>) clientRepo.findAll();
    }

    @Override
    public Client addClient(@NotNull Client c) {

        clientRepo.save(c);
        return c;
    }

    @Override
    public void deleteClient(@NotNull Client c) {
        clientRepo.deleteById(c.getIdClient());
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepo.save(c);
    }
}
