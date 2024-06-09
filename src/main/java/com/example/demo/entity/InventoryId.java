package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@ToString
@Getter
@Setter
@Embeddable
public class InventoryId implements Serializable {
    private Long storeId;
    private Long productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryId that = (InventoryId) o;

        if (!storeId.equals(that.storeId)) return false;
        return productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        int result = storeId.hashCode();
        result = 31 * result + productId.hashCode();
        return result;
    }
}
