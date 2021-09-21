package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Aplicado o padrão Decorator.
 *
 * O Decorator é um padrão de projeto estrutural que permite que você acople novos comportamentos para objetos ao
 * colocá-los dentro de invólucros de objetos que contém os comportamentos, ou seja, agrega dinamicamente
 * responsabilidades adicionais a um objeto. Decorators oferecem uma alternativa flexível ao uso de herança para
 * estender uma funcionalidade, com isso adiciona-se uma responsabilidade ao objeto e não à classe.
 */

public abstract class Imposto {

    private final Imposto outroImposto;

    public Imposto(Imposto outroImposto) {
        this.outroImposto = outroImposto;
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento){
        BigDecimal valorImposto = realizarCalculo(orcamento);
        BigDecimal valorOutroImposto = BigDecimal.ZERO;

        if (outroImposto != null)
            valorOutroImposto = outroImposto.realizarCalculo(orcamento);

        return valorImposto.add(valorOutroImposto);
    }

}
