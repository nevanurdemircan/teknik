package com.info.teknik.service;

import com.info.teknik.converter.CustomerMachinePartConverter;
import com.info.teknik.dto.CustomerAddMachinePartDto;
import com.info.teknik.dto.CustomerMachinePartDetailDto;
import com.info.teknik.dto.CustomerMachinePartGetAllDto;
import com.info.teknik.entity.Customer;
import com.info.teknik.entity.CustomerMachine;
import com.info.teknik.entity.Machine;
import com.info.teknik.entity.Part;
import com.info.teknik.repository.CustomerMachineRepository;
import com.info.teknik.repository.CustomerRepository;
import com.info.teknik.repository.MachineRepository;
import com.info.teknik.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerMachinePartService {

    private final CustomerRepository customerRepository;

    private final MachineRepository machineRepository;

    private final PartRepository partRepository;

    private final CustomerMachineRepository customerMachineRepository;

    private final CustomerMachinePartConverter converter;

    public ResponseEntity<Void> create(CustomerAddMachinePartDto customerAddMachinePartDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerAddMachinePartDto.getCustomerId());
        Optional<Machine> optionalMachine = machineRepository.findById(customerAddMachinePartDto.getMachineId());
        List<Part> parts = partRepository.findAllById(customerAddMachinePartDto.getPartIds());

        if (optionalCustomer.isEmpty() || optionalMachine.isEmpty()) {
            return ResponseEntity.notFound().build();
        }


        Customer customer = optionalCustomer.get();
        Machine machine = optionalMachine.get();

        CustomerMachine customerMachinePart = new CustomerMachine();
        customerMachinePart.setCustomer(customer);
        customerMachinePart.setMachine(machine);
        customerMachinePart.setCounter(customerAddMachinePartDto.getCounter());
        customerMachinePart.setParts(parts);

        customerMachineRepository.save(customerMachinePart);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> updateCounter(UUID id, Long counter) {
        Optional<CustomerMachine> optionalCustomerMachinePart = customerMachineRepository.findById(id);

        if (optionalCustomerMachinePart.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CustomerMachine machinePart = optionalCustomerMachinePart.get();

        machinePart.setCounter(counter);

        customerMachineRepository.save(machinePart);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<CustomerMachinePartGetAllDto>> getAllByCustomerId(UUID customerId) {
        List<CustomerMachine> customerMachineParts = customerMachineRepository.findAllByCustomerId(customerId);
        List<CustomerMachinePartGetAllDto> response = customerMachineParts.stream().map(converter::entityConvertToCustomerMachinePartGetAllDto).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<CustomerMachinePartDetailDto>> getDetail(UUID customerId) {
        List<CustomerMachine> customerMachineParts = customerMachineRepository.findAllByCustomerId(customerId);
        List<CustomerMachinePartDetailDto> response = customerMachineParts.stream().map(converter::entityConvertToCustomerMachinePartDetailDto).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
