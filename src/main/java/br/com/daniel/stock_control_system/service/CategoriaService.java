package br.com.daniel.stock_control_system.service;

import br.com.daniel.stock_control_system.entity.Categoria;
import br.com.daniel.stock_control_system.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    //O Spring fará isso através da injeção de dependência do CategoriaRepository
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository){
        this.repository = repository;
    }

    public List<Categoria> listar(){
        return repository.findAll();
    }

}
