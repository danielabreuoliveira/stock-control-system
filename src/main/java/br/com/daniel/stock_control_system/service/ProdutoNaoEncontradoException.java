package br.com.daniel.stock_control_system.service;

public class ProdutoNaoEncontradoException extends RuntimeException {

    public ProdutoNaoEncontradoException(Long id) {
        super("Produto com ID " + id + " não encontrado.");
    }

}
