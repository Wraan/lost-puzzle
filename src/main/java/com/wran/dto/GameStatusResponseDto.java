package com.wran.dto;

import com.wran.model.Item;
import com.wran.model.Location;
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
    private Location location;
    @ApiModelProperty(position = 3)
    private ResourcesResponseDto resources;
    @ApiModelProperty(position = 4)
    private List<Item> items;
    @ApiModelProperty(position = 5)
    private List<String> messages;

}
