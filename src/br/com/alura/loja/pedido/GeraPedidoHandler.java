package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Aplicado o padrão Observer.
 *
 * O Observer é um padrão de projeto comportamental que permite que um objeto notifique outros objetos sobre
 * alterações em seu estado.
 *
 * Quando um evento for disparado terá um ou mais ouvintes que se inscreveram e estão observando esse evento e eles
 * vão ser notificados, então vão executar a sua própria ação. Essa é a ideia. Há uma inversão do controle. Em vez de
 * chamarmos classe por classe, nós disparamos o evento e cada uma das classes vão ser notificadas e elas é que vão
 * reagir a esse evento. Essa é a ideia para você diminuir o acoplamento.
 */

public class GeraPedidoHandler {

    private final List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void executa(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

        acoes.forEach(a -> a.executarAcao(pedido));
    }
}
