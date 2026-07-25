package br.com.daniel.stock_control_system.controller;

import br.com.daniel.stock_control_system.dto.request.ProdutoRequest;
import br.com.daniel.stock_control_system.dto.response.ProdutoResponse;
import br.com.daniel.stock_control_system.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoResponse> listar(){
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public ProdutoResponse buscaPorId(@PathVariable Long id){
        return produtoService.buscaPorId(id);
    }

    @PostMapping
    public ProdutoResponse salvar(@RequestBody ProdutoRequest request){
        return produtoService.salvar(request);
    }

    @PutMapping("/{id}")
    public ProdutoResponse atualizar(@PathVariable Long id, @RequestBody ProdutoRequest request){
        return produtoService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        produtoService.excluir(id);
    }


}

