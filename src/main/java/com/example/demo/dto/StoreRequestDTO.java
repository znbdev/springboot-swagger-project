package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StoreRequestDTO {
    @NotNull(message = "Store ID is required")
    private Long id;
    private String name;
    private String address;
    @NumberFormat(pattern = "##-####-####")
    private String phoneNumber;
}
