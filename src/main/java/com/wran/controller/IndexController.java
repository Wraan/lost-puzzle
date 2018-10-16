package com.wran.controller;

import com.wran.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/")
    public String hello(){
        return "Hello!";
    }



}
