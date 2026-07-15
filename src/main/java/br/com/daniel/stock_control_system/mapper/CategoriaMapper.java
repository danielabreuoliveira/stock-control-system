package br.com.daniel.stock_control_system.mapper;

import br.com.daniel.stock_control_system.dto.request.CategoriaRequest;
import br.com.daniel.stock_control_system.dto.response.CategoriaResponse;
import br.com.daniel.stock_control_system.entity.Categoria;

public class CategoriaMapper {
    public static Categoria toEntity(CategoriaRequest dto){
        Categoria categoria = new Categoria();

        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());

        return categoria;
    }

    public static CategoriaResponse toResponse(Categoria categoria){

        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }

    public static void updateEntity(Categoria categoria, CategoriaRequest request){
        categoria.setNome(request.nome());
        categoria.setDescricao(request.descricao());
    }
}
