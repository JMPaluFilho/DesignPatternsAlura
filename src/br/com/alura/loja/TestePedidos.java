package br.com.alura.loja;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;

import java.math.BigDecimal;

public class TestePedidos {

    public static void main(String[] args) {
        String cliente = "Fulano";
        BigDecimal valorOrcamento = new BigDecimal("500");
        int quantidadeItens = 5;

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        GeraPedidoHandler handler = new GeraPedidoHandler(/* dependências */);
        handler.executa(gerador);
    }

}
