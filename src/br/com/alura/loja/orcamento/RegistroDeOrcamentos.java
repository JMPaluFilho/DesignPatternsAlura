package br.com.alura.loja.orcamento;

import br.com.alura.loja.exception.DomainException;
import br.com.alura.loja.http.HttpAdapter;

import java.util.Map;

/**
 * Aplicado o padrão Adapter.
 *
 * O Adapter é um padrão de projeto estrutural que permite objetos com interfaces incompatíveis colaborarem entre si.
 *
 * Ele é um objeto especial que converte a interface de um objeto para que outro objeto possa entendê-lo. Um adaptador
 * encobre um dos objetos para esconder a complexidade da conversão acontecendo nos bastidores.
 */

public class RegistroDeOrcamentos {

    private final HttpAdapter httpAdapter;

    public RegistroDeOrcamentos(HttpAdapter httpAdapter) {
        this.httpAdapter = httpAdapter;
    }

    public void registrar(Orcamento orcamento){
        if (!orcamento.isFinalizado())
            throw new DomainException("Orçamento não finalizado!");

        String url = "http://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getQuantidadeItens()
                );

        httpAdapter.post(url, dados);
    }

}
