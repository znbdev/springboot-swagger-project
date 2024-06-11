package com.example.demo.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class StorePk implements Serializable {

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "location_id")
    private Integer locationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorePk storePk = (StorePk) o;
        return Objects.equals(storeId, storePk.storeId) &&
                Objects.equals(locationId, storePk.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, locationId);
    }
}