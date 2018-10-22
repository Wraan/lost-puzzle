package com.wran.service;

import com.wran.dto.CommandDto;
import com.wran.exception.CustomException;
import com.wran.model.Client;
import com.wran.model.GameStatus;
import com.wran.model.Resources;
import com.wran.repository.GameStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GameStatusService {

    @Autowired
    GameStatusRepository gameStatusRepository;
    @Autowired
    CommandService commandService;

    public GameStatus getGameStatus(Client client){
        if(gameStatusRepository.existsByClient(client))
            return gameStatusRepository.findByClient(client);
        else
            return createNewGameStatus(client);
    }
    private GameStatus createNewGameStatus(Client client){
        GameStatus gameStatus = new GameStatus(client, new Resources(), 1,0);
        gameStatus.getResources().setGameStatus(gameStatus);
        return update(gameStatus);
    }
    private GameStatus update(GameStatus gameStatus){
        return gameStatusRepository.save(gameStatus);
    }
    public GameStatus resetGameStatus(Client client){
        if(gameStatusRepository.existsByClient(client))
            gameStatusRepository.deleteByClient(client);
        return createNewGameStatus(client);
    }
    public GameStatus proceedGame(Client client, CommandDto command) throws CustomException {
        GameStatus gameStatus = getGameStatus(client);
        nextMove(gameStatus);
        switch(command.getCommand().toLowerCase()){
            case "move":
                commandService.move(gameStatus, command.getParameter()); break;
            case "eat":
                break;
            default:
                throw new CustomException("Wrong command", HttpStatus.NOT_ACCEPTABLE);
        }
        return update(gameStatus);
    }
    private void nextMove(GameStatus gameStatus){
        gameStatus.setMoves(gameStatus.getMoves() + 1);
    }

}
