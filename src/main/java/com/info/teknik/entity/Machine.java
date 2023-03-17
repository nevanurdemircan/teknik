package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Machine extends BaseEntity {

    private String model;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private MachineBrand brand;

    @OneToMany(mappedBy="machine")
    private List<Part> parts;
}
