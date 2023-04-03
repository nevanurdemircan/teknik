package com.info.teknik.controller;

import com.info.teknik.dto.CustomerAddMachinePartDto;
import com.info.teknik.dto.CustomerMachinePartDetailDto;
import com.info.teknik.dto.CustomerMachinePartGetAllDto;
import com.info.teknik.service.CustomerMachinePartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer_machine_part")
@RequiredArgsConstructor
public class CustomerMachinePartController {
    private final CustomerMachinePartService customerMachinePartService;

    @PostMapping("create")
    public ResponseEntity<Void> create(CustomerAddMachinePartDto customerAddMachinePartDto) {
        return customerMachinePartService.create(customerAddMachinePartDto);
    }

    @PostMapping("update_counter/{id}")
    public ResponseEntity<Void> updateCounter(@PathVariable UUID id, Long counter) {
        return customerMachinePartService.updateCounter(id, counter);
    }

    @PostMapping("all_by_customer_id/{id}")
    public ResponseEntity<List<CustomerMachinePartGetAllDto>> getAllByCustomerId(@PathVariable UUID id) {
        return customerMachinePartService.getAllByCustomerId(id);
    }
@PostMapping("get_detail/{id}")
    public ResponseEntity<List<CustomerMachinePartDetailDto>> getDetail(@PathVariable UUID id){
        return customerMachinePartService.getDetail(id);
    }
}