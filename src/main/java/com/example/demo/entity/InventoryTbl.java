package com.example.demo.entity;

import com.example.demo.entity.common.CommonEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Version;

@Getter
@Setter
@Entity
@Table(name = "inventory_tbl")
public class InventoryTbl extends CommonEntity {

    @EmbeddedId
    private InventoryId id;

    @ManyToOne
    @MapsId("storeId")
    @JoinColumn(name = "store_id")
    private StoreTbl store;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductTbl product;

    @NotNull
    private int quantity;

    // Optimistic locking checks to see if a record has been modified by another transaction when the transaction is committed, and is usually implemented using a version number.
    @Version
    @NotNull
    private int version;

}