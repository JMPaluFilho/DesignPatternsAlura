package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.*;

import java.math.BigDecimal;

public class Orcamento {

    private BigDecimal valor;
    private final int quantidadeItens;
    private SituacaoOrcamento situacao;

    public Orcamento(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
        this.situacao = new EmAnalise();
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
        return quantidadeItens;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public boolean isFinalizado() {
        return situacao instanceof Finalizado;
    }

    @Override
    public String toString() {
        return "Orcamento {" +
                "valor = " + valor +
                ", quantidadeItens = " + quantidadeItens +
                ", situacao = " +
                (situacao instanceof EmAnalise ? "Em Análise" :
                        situacao instanceof Aprovado ? "Aprovado" :
                                situacao instanceof Reprovado ? "Reprovado" : "Finalizado") +
                "}";
    }

}
