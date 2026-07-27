package br.com.daniel.stock_control_system.repository;

import br.com.daniel.stock_control_system.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
