package com.app.ecom.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private String description;
    private BigDecimal price ;
    private Integer stockQuantity;
    private String category;
    private String imageUrl;
    private Boolean active = true;

}
