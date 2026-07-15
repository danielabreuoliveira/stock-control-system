package br.com.daniel.stock_control_system.repository;

import br.com.daniel.stock_control_system.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
