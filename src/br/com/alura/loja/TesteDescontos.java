package br.com.alura.loja;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteDescontos {

    public static void main(String[] args) {
        Orcamento primeiro = new Orcamento(new BigDecimal("200"), 6);
        Orcamento segundo = new Orcamento(new BigDecimal("1000"), 1);
        Orcamento terceiro = new Orcamento(new BigDecimal("400"), 4);

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
