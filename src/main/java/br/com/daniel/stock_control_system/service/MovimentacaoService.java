package br.com.daniel.stock_control_system.service;

import br.com.daniel.stock_control_system.dto.request.MovimentacaoRequest;
import br.com.daniel.stock_control_system.dto.response.MovimentacaoResponse;
import br.com.daniel.stock_control_system.entity.Movimentacao;
import br.com.daniel.stock_control_system.entity.Produto;
import br.com.daniel.stock_control_system.entity.TipoMovimentacao;
import br.com.daniel.stock_control_system.mapper.MovimentacaoMapper;
import br.com.daniel.stock_control_system.repository.MovimentacaoRepository;
import br.com.daniel.stock_control_system.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final ProdutoRepository produtoRepository;

    @Transactional
    public MovimentacaoResponse salvar(MovimentacaoRequest request){
        Produto produto = produtoRepository.findById(request.produtoId())
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado."));

        Movimentacao movimentacao = new Movimentacao();

        movimentacao.setProduto(produto);
        movimentacao.setTipo(request.tipo());
        movimentacao.setQuantidade(request.quantidade());
        movimentacao.setObservacao(request.observacao());
        movimentacao.setDataHora(LocalDateTime.now());

        switch (request.tipo()) {

            case ENTRADA -> produto.setEstoque(
                    produto.getEstoque() + request.quantidade()
            );

            case SAIDA -> {

                if (produto.getEstoque() < request.quantidade()) {
                    throw new RuntimeException("Estoque insuficiente.");
                }

                produto.setEstoque(
                        produto.getEstoque() - request.quantidade()
                );
            }
        }

        produtoRepository.save(produto);

        Movimentacao movimentacaoSalva = movimentacaoRepository.save(movimentacao);

        return MovimentacaoMapper.toResponse(movimentacaoSalva);
    }
}
