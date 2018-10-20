package com.wran.dto;

import com.wran.model.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClientDataDto {

    @ApiModelProperty(position = 0)
    private String username;
    @ApiModelProperty(position = 1)
    private String password;
    @ApiModelProperty(position = 1)
    private String email;
    @ApiModelProperty(position = 2)
    private List<Role> roles;
}
