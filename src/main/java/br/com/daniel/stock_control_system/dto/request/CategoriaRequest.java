package br.com.daniel.stock_control_system.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequest(
        @NotBlank
        @Size(min = 3, max = 100)
        String nome,

        @Size(max = 255)
        String descricao
) {

}
