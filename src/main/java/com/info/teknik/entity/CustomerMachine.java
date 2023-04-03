package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class CustomerMachine extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @ManyToMany
    @JoinTable(
            name = "parts-life",
            joinColumns = @JoinColumn(name = "customer-machine_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id"))

    private List<Part> parts;

    private Long counter;
}
