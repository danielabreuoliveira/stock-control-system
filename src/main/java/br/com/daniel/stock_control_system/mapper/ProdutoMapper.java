package br.com.daniel.stock_control_system.mapper;

import br.com.daniel.stock_control_system.dto.request.ProdutoRequest;
import br.com.daniel.stock_control_system.dto.response.ProdutoResponse;
import br.com.daniel.stock_control_system.entity.Produto;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoRequest request){

        Produto produto = new Produto();

        produto.setNome(request.nome());
        produto.setDescricao(request.descricao());
        produto.setPrecoCompra(request.precoCompra());
        produto.setPrecoVenda(request.precoVenda());
        produto.setEstoque(request.estoque());
        produto.setCodigoBarras(request.codigoBarras());
        produto.setAtivo(request.ativo());

        return produto;
    }

    public static ProdutoResponse toResponse(Produto produto){

        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPrecoCompra(),
                produto.getPrecoVenda(),
                produto.getEstoque(),
                produto.getCodigoBarras(),
                produto.isAtivo(),
                produto.getCategoria().getId(),
                produto.getCategoria().getNome()
        );
    }
}
