package br.com.daniel.stock_control_system.mapper;

import br.com.daniel.stock_control_system.dto.request.MovimentacaoRequest;
import br.com.daniel.stock_control_system.dto.response.MovimentacaoResponse;
import br.com.daniel.stock_control_system.entity.Movimentacao;

public class MovimentacaoMapper {

    public static MovimentacaoResponse toResponse(Movimentacao movimentacao) {

        return new MovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getProduto().getNome(),
                movimentacao.getTipo(),
                movimentacao.getQuantidade(),
                movimentacao.getObservacao(),
                movimentacao.getDataHora()
        );
    }

    public static Movimentacao toEntity(MovimentacaoRequest request){

        Movimentacao movimentacao = new Movimentacao();

        movimentacao.setTipo(request.tipo());
        movimentacao.setQuantidade(request.quantidade());
        movimentacao.setObservacao(request.observacao());


        return movimentacao;
    }

}