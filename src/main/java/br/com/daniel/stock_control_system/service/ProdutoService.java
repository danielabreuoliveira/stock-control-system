package br.com.daniel.stock_control_system.service;

import br.com.daniel.stock_control_system.dto.request.ProdutoRequest;
import br.com.daniel.stock_control_system.dto.response.ProdutoResponse;
import br.com.daniel.stock_control_system.entity.Categoria;
import br.com.daniel.stock_control_system.entity.Produto;
import br.com.daniel.stock_control_system.mapper.ProdutoMapper;
import br.com.daniel.stock_control_system.repository.CategoriaRepository;
import br.com.daniel.stock_control_system.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository){
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProdutoResponse salvar (ProdutoRequest request){

        Categoria categoria = categoriaRepository.findById(request.categoriaId()).orElseThrow(() -> new RuntimeException("categoria não encontrada"));

        Produto produto = ProdutoMapper.toEntity(request);

        produto.setCategoria(categoria);

        produtoRepository.save(produto);

        return ProdutoMapper.toResponse(produto);
    }

    public List<ProdutoResponse> listar(){

        return produtoRepository.findAll().stream().map(ProdutoMapper::toResponse).toList();
    }

    public ProdutoResponse buscaPorId(Long id){

        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));

        return ProdutoMapper.toResponse(produto);
    }
}
