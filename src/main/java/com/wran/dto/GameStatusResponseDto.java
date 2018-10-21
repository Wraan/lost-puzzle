package com.wran.dto;

import com.wran.model.Item;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GameStatusResponseDto {
    @ApiModelProperty(position = 0)
    private int day;
    @ApiModelProperty(position = 1)
    private int moves;
    @ApiModelProperty(position = 2)
    private ResourcesResponseDto resources;
    @ApiModelProperty(position = 3)
    private List<Item> items;
    @ApiModelProperty(position = 4)
    private List<String> messages;

}
