package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class TechnicalService extends BaseEntity {
    private Date date;
    private String process;
}
