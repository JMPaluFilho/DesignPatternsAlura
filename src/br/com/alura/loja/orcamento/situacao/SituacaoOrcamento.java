package br.com.alura.loja.orcamento.situacao;

import br.com.alura.loja.exception.DomainException;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Aplicado o padrão State.
 *
 * Esse padrão é utilizado quando temos uma transição de estados ou quando precisamos aplicar alguma regra ou algum
 * algoritmo baseado em um estado de um objeto de uma classe. Ele é parecido com o Strategy.
 *
 * O padrão State sugere que você crie novas classes para todos os estados possíveis de um objeto e extraia todos
 * os comportamentos específicos de estados para dentro dessas classes.
 * Ao invés de implementar todos os comportamentos por conta própria, o objeto original, chamado contexto, armazena
 * uma referência para um dos objetos de estado que representa seu estado atual, e delega o trabalho relacionado aos
 * estados para aquele objeto.
 *
 * Essa estrutura pode ser parecida com o padrão Strategy, mas há uma diferença chave. No padrão State, os estados em
 * particular podem estar cientes de cada um e iniciar transições de um estado para outro, enquanto que estratégias
 * quase nunca sabem sobre as outras estratégias.
 */

public abstract class SituacaoOrcamento {

    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    public void aprovar(Orcamento orcamento) {
        throw new DomainException("Orçamento não pode ser aprovado!");
    }

    public void reprovar(Orcamento orcamento) {
        throw new DomainException("Orçamento não pode ser reprovado!");
    }

    public void finalizar(Orcamento orcamento) {
        throw new DomainException("Orçamento não pode ser finalizado!");
    }

}
