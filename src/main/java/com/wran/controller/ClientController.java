package com.wran.controller;

import com.wran.dto.ClientDataDto;
import com.wran.model.Client;
import com.wran.model.Role;
import com.wran.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping(("/client"))
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{username}")
    public Client search(@PathVariable String username){
        return clientService.search(username);
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public Client whoAmI(HttpServletRequest req){
        return modelMapper.map(clientService.whoami(req), Client.class);
    }

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 422, message = "Username is already in use"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String signup(@ApiParam("Signup User") @RequestBody ClientDataDto user) {
        return clientService.signup(modelMapper.map(user, Client.class));
    }

}
