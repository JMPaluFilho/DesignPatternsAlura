package br.com.alura.loja.exception;

import java.io.Serial;

public class DomainException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1558711318689796101L;

    public DomainException(String mensagem) {
        super(mensagem);
    }

}
