package com.mesquitadev.goproducts.dto.responses;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private Long id;

    private String name;

    private String description;

    private String imageURL;

    private BigDecimal price;

    private Long quantity;
}
