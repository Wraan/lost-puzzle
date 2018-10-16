package com.wran.controller;

import com.wran.model.Client;
import com.wran.model.Role;
import com.wran.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(("/client"))
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{username}")
    public Client search(@PathVariable String username){
        return clientService.search(username);
    }
    @GetMapping("/reg/{username}")
    public Client test(@PathVariable String username){
        return clientService.signup(new Client(username, username, username+"@email.com", Arrays.asList(Role.ROLE_CLIENT)));
    }

}
