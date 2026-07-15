package br.com.daniel.stock_control_system.controller;

import br.com.daniel.stock_control_system.entity.Categoria;
import br.com.daniel.stock_control_system.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
