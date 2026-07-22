package br.com.daniel.stock_control_system.repository;

import br.com.daniel.stock_control_system.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByNomeContainingIgnoreCase(String nome);
}
