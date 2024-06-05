package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@ToString
@Getter
@Setter
@Entity
@Table(name = "inventory_tbl")
public class Inventory extends CommonEntity {
    @Id
    private Long productId;

    private int quantity;

    // Optimistic locking checks to see if a record has been modified by another transaction when the transaction is committed, and is usually implemented using a version number.
    @Version
    private int version;

}
