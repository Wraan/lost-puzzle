package com.wran.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "game_status_messages")
public class GameStatusMessage {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    private GameStatus gameStatus;

    @ManyToOne(cascade=CascadeType.ALL)
    private Message message;

    private int dayReceived;

    public String showMessage(){
        return message.getMessage();
    }

    @Override
    public String toString(){
        return showMessage();
    }

}
