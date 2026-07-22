package br.com.daniel.stock_control_system.service;

import br.com.daniel.stock_control_system.dto.request.CategoriaRequest;
import br.com.daniel.stock_control_system.dto.response.CategoriaResponse;
import br.com.daniel.stock_control_system.entity.Categoria;
import br.com.daniel.stock_control_system.mapper.CategoriaMapper;
import br.com.daniel.stock_control_system.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    //O Spring fará isso através da injeção de dependência do CategoriaRepository
    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<CategoriaResponse> listar(){
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaResponse> respostas = new ArrayList<>();

        for (Categoria categoria : categorias) {
            CategoriaResponse response = CategoriaMapper.toResponse(categoria);
            respostas.add(response);
        }
        return respostas;
        /*
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaMapper::toResponse)
                .toList();
         */
    }
    public CategoriaResponse salvar(CategoriaRequest request){
        Categoria categoria = CategoriaMapper.toEntity(request);

        Categoria categoriaSalva = categoriaRepository.save(categoria);

        return CategoriaMapper.toResponse(categoriaSalva);
    }

    public CategoriaResponse buscaPorId(Long id){
        Categoria categoria = categoriaRepository
                .findById(id)
                .orElseThrow();

        return CategoriaMapper.toResponse(categoria);
    }

    public List<CategoriaResponse> buscarPorNome(String nome){

        return categoriaRepository
                .findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(CategoriaMapper::toResponse)
                .toList();

    }

    public CategoriaResponse atualizar(Long id, CategoriaRequest request){

        Categoria categoria = categoriaRepository
                .findById(id)
                        .orElseThrow();

        CategoriaMapper.updateEntity(categoria, request);

        Categoria categoriaAtualizada = categoriaRepository.save(categoria);

        return CategoriaMapper.toResponse(categoriaAtualizada);
    }

    public void excluir(Long id){

        Categoria categoria = categoriaRepository.findById(id).orElseThrow();

        categoriaRepository.delete(categoria);
    }
}
