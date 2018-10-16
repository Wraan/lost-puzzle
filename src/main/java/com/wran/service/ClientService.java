package com.wran.service;

import com.wran.model.Client;
import com.wran.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client signup(Client client){
        return clientRepository.save(client);
    }
    public Client search(String username) { return clientRepository.findByUsername(username); }
}
