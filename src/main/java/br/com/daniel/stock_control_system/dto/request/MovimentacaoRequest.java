package br.com.daniel.stock_control_system.dto.request;

import br.com.daniel.stock_control_system.entity.TipoMovimentacao;

public record MovimentacaoRequest(

        Long produtoId,

        TipoMovimentacao tipo,

        Integer quantidade,

        String observacao

) {
}