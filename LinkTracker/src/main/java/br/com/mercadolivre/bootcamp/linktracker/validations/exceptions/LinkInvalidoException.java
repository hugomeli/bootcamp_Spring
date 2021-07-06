package br.com.mercadolivre.bootcamp.linktracker.validations.exceptions;

public class LinkInvalidoException extends RuntimeException{

    public LinkInvalidoException() {
        super("Invalid link!");
    }
}
