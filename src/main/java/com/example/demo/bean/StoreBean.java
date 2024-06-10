package com.example.demo.bean;

import lombok.Data;

import javax.persistence.Column;

@Data
public class StoreBean {

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
}
