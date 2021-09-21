package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

/**
 * Aplicado o padrão Proxy.
 *
 * O Proxy é um padrão de projeto estrutural que permite que você forneça um substituto ou um espaço reservado para
 * outro objeto. Um proxy controla o acesso ao objeto original, permitindo que você faça algo ou antes ou depois do
 * pedido chegar ao objeto original.
 *
 * O padrão Proxy sugere que você crie uma nova classe proxy com a mesma interface do objeto do serviço original.
 * Então você atualiza sua aplicação para que ela passe o objeto proxy para todos os clientes do objeto original.
 * Ao receber uma solicitação de um cliente, o proxy cria um objeto do serviço real e delega a ele o trabalho.
 */

public class OrcamentoProxy extends Orcamento {

    private BigDecimal valor;
    private Orcamento orcamento;

    public OrcamentoProxy(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getValor() {
        if (valor == null)
            this.valor = orcamento.getValor();

        return this.valor;
    }

}
