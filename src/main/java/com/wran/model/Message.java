package com.wran.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String message;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<GameStatusMessage> messages = new ArrayList<>();
}
