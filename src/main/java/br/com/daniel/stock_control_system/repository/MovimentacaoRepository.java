package br.com.daniel.stock_control_system.repository;

import br.com.daniel.stock_control_system.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
