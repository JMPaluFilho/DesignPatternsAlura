package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;

import java.time.LocalDateTime;

public class Pedido {

    private final String cliente;
    private final LocalDateTime data;
    private final Orcamento orcamento;

    public Pedido(String cliente, LocalDateTime data, Orcamento orcamento) {
        this.cliente = cliente;
        this.data = data;
        this.orcamento = orcamento;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    @Override
    public String toString() {
        return "Pedido {" +
                "cliente = '" + cliente + '\'' +
                ", data = " + data +
                ", orcamento = " + orcamento +
                "}";
    }

}
