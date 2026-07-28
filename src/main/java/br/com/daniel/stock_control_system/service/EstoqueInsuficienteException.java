package br.com.daniel.stock_control_system.service;

public class EstoqueInsuficienteException extends RuntimeException {

    public EstoqueInsuficienteException() {
        super("Estoque insuficiente para realizar a saída.");
    }

}
