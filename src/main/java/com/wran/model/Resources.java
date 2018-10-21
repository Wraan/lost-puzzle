package com.wran.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "resources")
public class Resources {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private GameStatus gameStatus;
    private int wood;
    private int energy = 50;
    private int maxEnergy = 100;
    private int food;
    private int maxFood = 100;
    private int skins;
}
