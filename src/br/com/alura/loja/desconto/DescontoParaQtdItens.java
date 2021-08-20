package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoParaQtdItens extends Desconto {

    public DescontoParaQtdItens(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    @Override
    public boolean deveAplicarDesconto(Orcamento orcamento) {
        return orcamento.getQuantidadeItens() > 5;
    }
}
