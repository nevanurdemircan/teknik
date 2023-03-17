package com.info.teknik.converter;

import com.info.teknik.dto.PartDto;
import com.info.teknik.entity.Part;
import org.springframework.stereotype.Component;

@Component
public class PartConverter {
    public PartDto partConvertPartDto(Part part) {
        PartDto partDto = new PartDto();
        partDto.setName(part.getName());
        partDto.setServiceLife(part.getServiceLife());
        return partDto;
    }

    public Part partDtoConvertPart(PartDto dto) {
        Part part = new Part();
        part.setName(dto.getName());
        part.setServiceLife(dto.getServiceLife());
        return part;
    }
}
