package com.info.teknik.converter;

import com.info.teknik.dto.CustomerMachinePartDetailDto;
import com.info.teknik.dto.CustomerMachinePartGetAllDto;
import com.info.teknik.entity.CustomerMachine;
import org.springframework.stereotype.Component;

@Component
public class CustomerMachinePartConverter {
    public CustomerMachinePartGetAllDto entityConvertToCustomerMachinePartGetAllDto (CustomerMachine entity){
        CustomerMachinePartGetAllDto dto = new CustomerMachinePartGetAllDto();
        dto.setId(entity.getId());
        dto.setCustomerName(entity.getCustomer().getName());
        dto.setMachineModel(entity.getMachine().getModel());

        return dto;
    }
   public CustomerMachinePartDetailDto entityConvertToCustomerMachinePartDetailDto (CustomerMachine entity){
        CustomerMachinePartDetailDto dto = new CustomerMachinePartDetailDto();
        dto.setMachineName(entity.getMachine().getBrand().getName());
        return dto;
   }
}
