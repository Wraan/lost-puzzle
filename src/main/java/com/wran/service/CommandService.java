package com.wran.service;

import com.wran.exception.CustomException;
import com.wran.model.GameStatus;
import com.wran.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommandService {
    void move(GameStatus gameStatus, String parameter) throws CustomException{
        Location location = getNewLocation(parameter);
        //TODO change energy status
        gameStatus.setLocation(location);
    }
    void eat(GameStatus gameStatus, String parameter){

    }
    void search(GameStatus gameStatus){

    }
    void hunt(GameStatus gameStatus){

    }
    void sleep(GameStatus gameStatus){

    }
    void craft(GameStatus gameStatus, String parameter){

    }
    void upgrade(GameStatus gameStatus, String parameter){

    }
    void scout(){

    }
    private Location getNewLocation(String parameter){
        switch(parameter.toLowerCase()) {
            case "beach":
                return Location.Beach;
            case "cave":
                return Location.Cave;
            case "forest":
                return Location.Forest;
            default:
                throw new CustomException("Wrong parameter", HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
