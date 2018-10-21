package com.wran.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientDataDto {

    @ApiModelProperty(position = 0)
    private String username;
    @ApiModelProperty(position = 1)
    private String password;
    @ApiModelProperty(position = 1)
    private String email;
}
