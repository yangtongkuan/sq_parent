package com.yang.sq.model.entity.test;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "test_pro")
@Entity
@Data
public class TestPro {

    @GeneratedValue
    @Id
    private Long id;

    private String test;

}
