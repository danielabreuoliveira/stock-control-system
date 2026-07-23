package br.com.daniel.stock_control_system.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public record ProdutoRequest(

        String nome,
        String descricao,
        BigDecimal precoCompra,
        BigDecimal precoVenda,
        Integer estoque,
        String codigoBarras,
        boolean ativo,
        Long categoriaId
) {



}
