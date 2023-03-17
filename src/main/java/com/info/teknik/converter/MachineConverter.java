package com.info.teknik.converter;

import com.info.teknik.dto.MachineCreateDto;
import com.info.teknik.dto.MachineDto;
import com.info.teknik.dto.PartDto;
import com.info.teknik.entity.Machine;
import com.info.teknik.entity.MachineBrand;
import com.info.teknik.entity.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MachineConverter {
    private final PartConverter partConverter;
    public MachineDto machineConvertToMachineDto(Machine machine){
        List<PartDto> parts = machine.getParts().stream().map(partConverter::partConvertPartDto).collect(Collectors.toList());

        MachineDto machineDto = new MachineDto();
        machineDto.setModel(machine.getModel());
        machineDto.setBrandName(machine.getBrand().getName());
        machineDto.setParts(parts);

        return machineDto;
    }

    public Machine machineCreateDtoConvertToMachine(MachineCreateDto dto){
        Machine machine = new Machine();
        MachineBrand brand = new MachineBrand();
        brand.setId(dto.getBrandId());
        machine.setModel(dto.getModel());
        machine.setBrand(brand);

        return machine;
    }

}
