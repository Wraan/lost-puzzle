package com.wran.controller;

import com.wran.dto.CommandDto;
import com.wran.dto.GameStatusResponseDto;
import com.wran.service.ClientService;
import com.wran.service.GameStatusService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/game")
@Api(tags = "game")
public class GameController {
    @Autowired
    ClientService clientService;
    @Autowired
    GameStatusService gameStatusService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public GameStatusResponseDto showGameStatus(HttpServletRequest req){
        return modelMapper.map(gameStatusService.getGameStatus(clientService.whoami(req)),
                GameStatusResponseDto.class);
    }

    @DeleteMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public GameStatusResponseDto resetGameStatus(HttpServletRequest req){
        return modelMapper.map(gameStatusService.resetGameStatus(clientService.whoami(req)),
                GameStatusResponseDto.class);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public GameStatusResponseDto proceedGame(@RequestBody CommandDto command, HttpServletRequest req){
        return modelMapper.map(gameStatusService.proceedGame(clientService.whoami(req), command),
                GameStatusResponseDto.class);
    }
}
