package com.stage.wael.controllers;

import com.stage.wael.entities.Client;
import com.stage.wael.repositories.ClientRepository;
import com.stage.wael.services.IClientService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api("gestion des client")
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    IClientService clientService;
    @Autowired
    ClientRepository clientRepository;

    //*************fetch all***************
    @GetMapping("/retrieve-all-clients")
    @ResponseBody
    public List<Client> getAllClient(){

        return  clientService.retrieveAllClient();
    }

    //*************add client ***************
    @PostMapping("/add-client")
    @ResponseBody
    public Client addClient(@RequestBody Client c){

        return clientService.addClient(c);

    }
    //**************** fetch by id ******************
    @GetMapping("/retrieve-client/{id}")
    @ResponseBody
    public Serializable retrieveOneClient(@PathVariable("id")Long id){

        return clientService.retrieveClient(id) !=null?clientService.retrieveClient(id):new ArrayList<Lookup>();

    }
    //*******delete client by id****************
    @DeleteMapping("/delete-client/{id}")
    public void deleteClient(@PathVariable("id")Long id){
        Client c =clientRepository.findById(id).orElse(null);
        clientService.deleteClient(c);
    }
    @PutMapping("/update-client")
    @ResponseBody
    public Client updateClient(@RequestBody Client c){
        return clientService.updateClient(c);
    }






}
