package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;

public class GeraPedido {

    private final String cliente;
    private final Orcamento orcamento;

    public GeraPedido(String cliente, Orcamento orcamento) {
        this.cliente = cliente;
        this.orcamento = orcamento;
    }

    public String getCliente() {
        return cliente;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

}
