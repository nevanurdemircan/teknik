package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MachineDto {
    private String model;

    private String brandName;

    private List<PartDto> parts;
}
