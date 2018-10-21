package com.wran.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "game_statuses")
public class GameStatus {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToOne(mappedBy = "gameStatus", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Resources resources;

    private int moves;
    private int day;

    @OneToMany(mappedBy = "gameStatus", cascade = CascadeType.ALL)
    private List<GameStatusMessage> messages = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Item> items;

    public GameStatus() {
    }
    public GameStatus(Client client, Resources resources, int day, int moves){
        this.client = client;
        this.resources = resources;
        this.moves = moves;
        this.day = day;
    }
}
