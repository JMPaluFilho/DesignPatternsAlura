package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Aplicado o padrão Strategy.
 *
 * A ideia é sempre que tiver um algoritmo, validação, cálculo ou qualquer outra regra
 * que varia de acordo com um determinado parâmetro, de acordo com determinada informação,
 * costuma-se ter um código cheio de if e else.
 *
 * Então para eliminar os if e else, pode-se usar o Strategy. Ao invés dessa informação ser uma String
 * ou ser um "enum", pode ser uma própria classe e nessa classe, pode-se usar o polimorfismo com “interface”
 * ou com classes abstratas para ter a sua implementação específica, ter a sua estratégia de cálculo específico.
 *
 * O padrão Strategy vem para resolver esse problema, para deixar o código mais coeso onde cada classe
 * tem a sua estratégia específica, uma não conhece a outra.
 */

public class CalculadoraDeImpostos {

    public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
      return imposto.calcular(orcamento);
    }

}
