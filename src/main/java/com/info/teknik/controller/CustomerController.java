package com.info.teknik.controller;

import com.info.teknik.dto.CustomerCreateDto;
import com.info.teknik.dto.CustomerDto;
import com.info.teknik.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CustomerCreateDto customerCreateDto) {
        return customerService.create(customerCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return customerService.getAll();
    }

}
