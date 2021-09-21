package br.com.alura.loja;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteDescontos {

    public static void main(String[] args) {
        Orcamento primeiro = new Orcamento();
        primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("200")));

        Orcamento segundo = new Orcamento();
        segundo.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));

        Orcamento terceiro = new Orcamento();
        terceiro.adicionarItem(new ItemOrcamento(new BigDecimal("500")));


        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();

        System.out.println(calculadoraDeDescontos.calcular(primeiro));
        System.out.println(calculadoraDeDescontos.calcular(segundo));
        System.out.println(calculadoraDeDescontos.calcular(terceiro));

        primeiro.aplicarDescontoExtra();
        System.out.println(primeiro.getValor());

        segundo.aprovar();
        segundo.aplicarDescontoExtra();
        System.out.println(segundo.getValor());

        try {
            primeiro.reprovar();
            primeiro.aprovar();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            segundo.reprovar();
            segundo.aprovar();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            terceiro.finalizar();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
