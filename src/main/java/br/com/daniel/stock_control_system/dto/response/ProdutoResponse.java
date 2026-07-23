package br.com.daniel.stock_control_system.dto.response;

import java.math.BigDecimal;

public record ProdutoResponse(

        Long id,
        String nome,
        String descricao,
        BigDecimal precoCompra,
        BigDecimal precoVenda,
        Integer estoque,
        String codigoBarras,
        boolean ativo,
        Long categoriaId,
        String categoriaNome
) {
}
