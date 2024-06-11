package com.example.demo.db.entity;

import com.example.demo.db.entity.common.TimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "test_store_tbl")
public class StoreTbl extends TimeEntity {
    @EmbeddedId
    private StorePk storePk;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
}
