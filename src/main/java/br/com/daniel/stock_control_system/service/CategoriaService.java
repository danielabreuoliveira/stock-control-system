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

    public Categoria salvar(Categoria categoria){
        return repository.save(categoria);
    }

    public Categoria buscaPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
    }

    public Categoria atualizar(Long id, Categoria categoriaAtualizada){
        Categoria categoria = buscaPorId(id);

        categoria.setNome(categoriaAtualizada.getNome());
        categoria.setDescricao(categoriaAtualizada.getDescricao());

        return repository.save(categoria);
    }

    public void excluir(Long id){
        Categoria categoria = buscaPorId(id);
        repository.delete(categoria);
    }
}
