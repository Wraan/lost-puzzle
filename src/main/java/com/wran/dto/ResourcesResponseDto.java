package com.wran.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResourcesResponseDto {
    @ApiModelProperty(position = 0)
    private int wood;
    @ApiModelProperty(position = 1)
    private int energy;
    @ApiModelProperty(position = 2)
    private int maxEnergy;
    @ApiModelProperty(position = 3)
    private int food;
    @ApiModelProperty(position = 4)
    private int maxFood;
    @ApiModelProperty(position = 5)
    private int skins;
}
