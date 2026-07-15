package br.com.daniel.stock_control_system.controller;

import br.com.daniel.stock_control_system.entity.Categoria;
import br.com.daniel.stock_control_system.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/categorias")
    public List<Categoria> listar(){
        return service.listar();
    }

    @PostMapping("/categorias")
    public Categoria salvar(@RequestBody Categoria categoria){
        return service.salvar(categoria);
    }

    @GetMapping("/categorias/{id}")
    public Categoria buscaPorId(@PathVariable Long id){
        return service.buscaPorId(id);
    }

    @PutMapping("/categorias/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        return service.atualizar(id, categoria);
    }

    @DeleteMapping("/categorias/{id}")
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }
}
