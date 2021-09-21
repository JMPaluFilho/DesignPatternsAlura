package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Aplicado o padrão Composite.
 *
 * O Composite é um padrão de projeto estrutural que permite que você componha objetos em estruturas de árvores e
 * então trabalhe com essas estruturas como se elas fossem objetos individuais.
 *
 * O maior benefício dessa abordagem é que você não precisa se preocupar sobre as classes concretas dos objetos
 * que compõem essa árvore. Você pode tratar todos eles com a mesma interface. Quando você chama um método os próprios
 * objetos passam o pedido pela árvore.
 *
 * Tal padrão é, normalmente, utilizado para representar listas recorrentes ou recursivas de elementos. Além disso,
 * este modo de representação hierárquica de classes permite que os elementos contidos em um objeto composto sejam
 * tratados como se fossem um objeto único. Desta forma, os métodos comuns às classes podem ser aplicados, também,
 * ao conjunto agrupado no objeto composto.
 */

public class Orcamento implements Orcavel {

    private BigDecimal valor;
    private SituacaoOrcamento situacao;
    private List<Orcavel> itens;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.situacao = new EmAnalise();
        this.itens = new ArrayList<>();
    }

    public void aplicarDescontoExtra() {
        BigDecimal valorDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDescontoExtra);
    }

    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public boolean isFinalizado() {
        return situacao instanceof Finalizado;
    }

    public void adicionarItem(Orcavel item) {
        this.valor = valor.add(item.getValor());
        this.itens.add(item);
    }

    @Override
    public String toString() {
        return "Orcamento {" +
                "valor = " + valor +
                ", quantidadeItens = " + itens.size() +
                ", situacao = " +
                (situacao instanceof EmAnalise ? "Em Análise" :
                        situacao instanceof Aprovado ? "Aprovado" :
                                situacao instanceof Reprovado ? "Reprovado" : "Finalizado") +
                "}";
    }

}
