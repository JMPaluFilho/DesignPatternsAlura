package br.com.alura.loja.pedido;

import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Aplicado o padrão Facade.
 *
 * O Facade é um padrão de projeto estrutural que fornece uma interface simplificada para uma biblioteca, um framework,
 * ou qualquer conjunto complexo de classes.
 *
 * Uma fachada é uma classe que fornece uma interface simples para um subsistema complexo que contém muitas partes que
 * se movem. Uma fachada pode fornecer funcionalidades limitadas em comparação com trabalhar com os subsistemas
 * diretamente. Contudo, ela inclui apenas aquelas funcionalidades que o cliente se importa.
 */

public class GeraPedidoHandler {

    private final List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void executa(GeraPedido dados) {
        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), dados.getOrcamento());

        acoes.forEach(a -> a.executarAcao(pedido));
    }
}
