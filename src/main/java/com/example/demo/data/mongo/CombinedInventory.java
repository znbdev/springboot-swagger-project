package com.example.demo.data.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@Document(collection = "combined_inventory")
public class CombinedInventory {
    @Id
    private String id;
    private String storeId;
    private String storeName;
    private String storeAddress;
    private String storePhoneNumber;
    private Long productId;
    private String productName;
    private String productDescription;
    private int quantity;
}
