package com.info.teknik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerMachinePartRepository extends JpaRepository<CustomerMachinePart, UUID> {

}
