package com.wran;

import com.wran.model.Client;
import com.wran.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LostPuzzleApplication implements CommandLineRunner {

    @Autowired
    ClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(LostPuzzleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        clientService.signup(new Client("admin", "admin", "admin@email.com"));
        clientService.signup(new Client("client", "client", "client@email.com"));

    }
}
