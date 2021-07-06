package br.com.mercadolivre.bootcamp.linktracker.validations.exceptions;

public class SenhaInvalidaException extends RuntimeException{

    public SenhaInvalidaException() {
        super("Senha invalida!");
    }
}
