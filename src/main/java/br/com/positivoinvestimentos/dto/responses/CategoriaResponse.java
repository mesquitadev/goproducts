package br.com.positivoinvestimentos.dto.responses;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class CategoriaResponse {
    private Long id;

    private String nome;

    private Long percentual;
}
