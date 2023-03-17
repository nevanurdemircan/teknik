package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class CustomerMachine extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id")
    private Machine machine;

    @ManyToMany
    @JoinTable(
            name = "parts-life",
            joinColumns = @JoinColumn(name = "customer-machine_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id"))

    private List<Part> parts;

    private Long counter;
}
