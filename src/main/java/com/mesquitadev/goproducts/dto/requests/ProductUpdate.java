package com.mesquitadev.goproducts.dto.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class ProductUpdate {

    @Size(min = 4, max = 50)
    private String name;

    @Size(min = 4, max = 50)
    private String description;

    @Size(min=4, max=200)
    private String imageURL;

    @NotNull
    private Long quantity;

    private BigDecimal price;
}
