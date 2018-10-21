package com.wran.service;

import com.wran.dto.CommandDto;
import com.wran.model.Client;
import com.wran.model.GameStatus;
import com.wran.model.Resources;
import com.wran.repository.GameStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameStatusService {

    @Autowired
    GameStatusRepository gameStatusRepository;

    public GameStatus getGameStatus(Client client){
        if(gameStatusRepository.existsByClient(client))
            return gameStatusRepository.findByClient(client);
        else
            return createNewGameStatus(client);
    }

    public GameStatus createNewGameStatus(Client client){
        return new GameStatus(client, new Resources(), 1,0);
    }
    public GameStatus update(GameStatus gameStatus){
        return gameStatusRepository.save(gameStatus);
    }
    public GameStatus resetGameStatus(Client client){
        if(gameStatusRepository.existsByClient(client))
            gameStatusRepository.deleteByClient(client);
        return createNewGameStatus(client);
    }
    public GameStatus proceedGame(Client client, CommandDto command){
        //TODO implement sth
        return createNewGameStatus(client);
    }
}
