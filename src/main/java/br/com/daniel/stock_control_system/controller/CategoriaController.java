package br.com.daniel.stock_control_system.controller;

import br.com.daniel.stock_control_system.dto.request.CategoriaRequest;
import br.com.daniel.stock_control_system.dto.response.CategoriaResponse;
import br.com.daniel.stock_control_system.entity.Categoria;
import br.com.daniel.stock_control_system.mapper.CategoriaMapper;
import br.com.daniel.stock_control_system.repository.CategoriaRepository;
import br.com.daniel.stock_control_system.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaResponse> listar(){

        return categoriaService.listar();
    }

    @PostMapping
    public CategoriaResponse salvar(
            @RequestBody CategoriaRequest request){

        return categoriaService.salvar(request);
    }

    @GetMapping("/{id}")
    public CategoriaResponse buscaPorId(@PathVariable Long id) {
        System.out.println("Entrou no buscar por id: " +id);
        return categoriaService.buscaPorId(id);
    }
    @GetMapping("/buscar")
    public List<CategoriaResponse> buscar(@RequestParam String nome){

        return categoriaService.buscarPorNome(nome);

    }

    @PutMapping("/{id}")
    public CategoriaResponse atualizar(@PathVariable Long id, @RequestBody CategoriaRequest request){
        return categoriaService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){

        categoriaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
