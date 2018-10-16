package com.wran.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;

    public Client(){}
    public Client(String username, String password, String email, List<Role> roles){
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }
}
