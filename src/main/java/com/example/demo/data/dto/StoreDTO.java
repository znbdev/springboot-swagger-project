package com.example.demo.data.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StoreDTO {
    @NotNull(message = "Store ID is required")
    private Integer storeId;
    @NotNull(message = "Location ID is required")
    private Integer locationId;
    private String name;
    private String address;
    @NumberFormat(pattern = "##-####-####")
    private String phoneNumber;
}
