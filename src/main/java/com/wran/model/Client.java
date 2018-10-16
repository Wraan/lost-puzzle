package com.wran.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    public Client(){}
    public Client(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
