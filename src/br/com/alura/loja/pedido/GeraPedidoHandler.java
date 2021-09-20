package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;

import java.time.LocalDateTime;

/**
 * Aplicado o padrão Command Handler.
 *
 * O Command é um padrão de projeto comportamental que converte solicitações ou operações simples em objetos.
 *
 * O padrão Command é um padrão de comportamento em que um objeto é utilizado para encapsular toda informação
 * necessária para executar uma ação ou disparar um evento em um momento futuro. Levando-se em conta que hoje
 * é possível receber essa informação de várias formas (RestAPI, XML, Web, etc.), o command handler ajusta o
 * padrão Command, fazendo a separação de informações e ações, o que vai um pouco contra a ideia de orientação
 * a objeto, porém evitando a duplicação de código desnecessário nos casos da fonte da informação serem de locais
 * diferentes.
 */

public class GeraPedidoHandler {

    //construtor com injeção de dependências: repository, service, etc.

    public void executa(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

        System.out.println("Lógica para salvar pedido no banco de dados...");
        System.out.println("Lógica para enviar e-mail com dados do novo pedido...");
        System.out.println(pedido);
    }
}
