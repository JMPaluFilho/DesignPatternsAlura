package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Aplicado o padrão Template Method.
 *
 * Um Template Method auxilia na definição de um algoritmo com partes do mesmo definidos por métodos abstratos.
 * As subclasses devem se responsabilizar por estas partes abstratas que serão implementadas, possivelmente,
 * de várias formas, ou seja, cada subclasse irá implementar à sua necessidade e oferecer um comportamento concreto.
 *
 * O Template Method fornece uma estrutura fixa, de um algoritmo, esta parte fixa deve estar presente na superclasse,
 * sendo obrigatório uma classeAbstrata que possa conter um método concreto, pois em uma interface só é possível
 * conter métodos abstratos que definem um comportamento, esta é a vantagem de ser uma Classe Abstrata porque
 * também irá fornecer métodos abstratos às suas subclasses, que por sua vez herdam este método, por Herança, e
 * devem implementar os métodos abstratos fornecendo um comportamento concreto aos métodos que foram definidos
 * como abstratos.
 */

public abstract class Desconto {

    protected Desconto proximo;

    public Desconto(Desconto proximo) {
        this.proximo = proximo;
    }

    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);

    protected abstract boolean deveAplicarDesconto(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento) {
        if(deveAplicarDesconto(orcamento)) {
            return efetuarCalculo(orcamento);
        }

        return proximo.calcular(orcamento);
    }
}
