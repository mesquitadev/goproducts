package br.com.positivoinvestimentos.dto.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class ProductPersist {

    @NotBlank
    @Size(min=4, max=50)
    private String name;

    @NotBlank
    @Size(min=4, max=50)
    private String description;

    @NotBlank
    @Size(min=4, max=200)
    private String imageURL;

    @NotNull
    private Long quantity;

    @NotNull(message = "O CAMPO PREÇO NÃO PODE SER VAZIO")
    private BigDecimal price;

}
