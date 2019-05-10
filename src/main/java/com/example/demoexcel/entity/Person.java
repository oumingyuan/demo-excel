package com.example.demoexcel.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;
    private String address;
}
