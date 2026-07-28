package br.com.daniel.stock_control_system.dto.response;

import br.com.daniel.stock_control_system.entity.TipoMovimentacao;

import java.time.LocalDateTime;

public record MovimentacaoResponse(

        Long id,

        String produto,

        TipoMovimentacao tipo,

        Integer quantidade,

        String observacao,

        LocalDateTime dataHora

) {
}