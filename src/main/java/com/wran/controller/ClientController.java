package com.wran.controller;

import com.wran.dto.ClientDataDto;
import com.wran.dto.ClientLoginDto;
import com.wran.dto.ClientResponseDto;
import com.wran.exception.CustomException;
import com.wran.model.Client;
import com.wran.service.ClientService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(("/client"))
@Api(tags = "client")
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/login")
    @ApiOperation(value = "${UserController.login}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 422, message = "Invalid username/password supplied")})
    public String login(//
                        @ApiParam("Client Login") @RequestBody ClientLoginDto client,
                        HttpServletResponse res) throws IOException {
        try {
            return clientService.login(client.getUsername(), client.getPassword());
        }
        catch(CustomException e){
            res.sendError(e.getHttpStatus().value(), e.getMessage());
            return null;
        }
    }

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 422, message = "Username is already in use"),})
    public String signup(@ApiParam("Signup Client") @RequestBody ClientDataDto client, HttpServletResponse res) throws IOException {
        try{
            return clientService.signup(modelMapper.map(client, Client.class));
        }
        catch(CustomException e){
            res.sendError(e.getHttpStatus().value(), e.getMessage());
            return null;
        }
    }

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${UserController.search}", response = ClientResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public ClientResponseDto search(@ApiParam("Username") @PathVariable String username,
                                    HttpServletResponse res) throws IOException{
        try{
            return modelMapper.map(clientService.search(username), ClientResponseDto.class);
        }
        catch(CustomException e){
            res.sendError(e.getHttpStatus().value(), e.getMessage());
            return null;
        }
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${UserController.delete}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String delete(@ApiParam("Username") @PathVariable String username,
                         HttpServletResponse res) throws IOException {
        try{
            clientService.delete(username);
            return username;
        }
        catch(CustomException e){
            res.sendError(e.getHttpStatus().value(), e.getMessage());
            return null;
        }

    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${UserController.me}", response = ClientResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public ClientResponseDto whoami(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try{
            return modelMapper.map(clientService.whoami(req), ClientResponseDto.class);
        }
        catch(CustomException e){
            res.sendError(e.getHttpStatus().value(), e.getMessage());
            return null;
        }
    }
}
