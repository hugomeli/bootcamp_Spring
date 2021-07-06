package br.com.mercadolivre.bootcamp.linktracker.validations.handlers;

import br.com.mercadolivre.bootcamp.linktracker.validations.exceptions.LinkInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LinkInvalidoHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(LinkInvalidoException.class)
    public ResponseEntity<?> handleLinkIvalidoException(LinkInvalidoException exception){
        return ResponseEntity.notFound().build();
    }
}
