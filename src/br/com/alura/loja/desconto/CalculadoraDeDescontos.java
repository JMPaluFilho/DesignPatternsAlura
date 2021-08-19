package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Aplicado o padrão Chain of Responsibility.
 *
 * O Chain of Responsibility é um padrão de projeto comportamental que permite que se
 * passe o orçamento por uma corrente de handlers. Ao receber um orçamento, cada handler decide
 * se processa o desconto ou o passa adiante para o próximo handler na corrente.
 *
 * Como muitos outros padrões de projeto comportamental, o Chain of Responsibility se baseia
 * em transformar certos comportamentos em objetos solitários chamados handlers. Neste caso,
 * cada checagem devem ser extraída para sua própria classe com um único método que faz a checagem.
 *
 * O padrão sugere que se ligue esses handlers em uma corrente. Cada handler ligado tem um campo
 * para armazenar uma referência ao próximo handler da corrente. Além de processar o orçamento,
 * handlers o passam adiante na corrente. O orçamento viaja através da corrente até que todos os
 * handlers tiveram uma chance de processá-lo ou se algum handler encerra a corrente.
 */

public class CalculadoraDeDescontos {

    public BigDecimal calcular(Orcamento orcamento) {
        Desconto desconto = new DescontoParaQtdItens(
                            new DescontoParaValor(
                            new SemDesconto()));

        return desconto.calcular(orcamento);
    }
}
