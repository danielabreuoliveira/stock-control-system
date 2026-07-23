package br.com.daniel.stock_control_system.repository;

import br.com.daniel.stock_control_system.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    <S extends Produto> S save(S entity);
    void delete(Produto entity);
    void deleteById(Long id);
    boolean existsById(Long id);
}
