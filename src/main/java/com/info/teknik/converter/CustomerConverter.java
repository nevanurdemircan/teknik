package com.info.teknik.converter;

import com.info.teknik.dto.CustomerCreateDto;
import com.info.teknik.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    public Customer customerCreateDtoConvertToCustomer(CustomerCreateDto dto){
        Customer customer = new Customer();
        customer.setAddress(dto.getAddress());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        return customer;
    }
}
