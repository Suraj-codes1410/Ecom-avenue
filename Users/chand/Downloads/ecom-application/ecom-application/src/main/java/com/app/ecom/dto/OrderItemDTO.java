package com.app.ecom.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
     private Long id ;
     private Integer productId;
     private Integer quantity;
     private BigDecimal price;
}
