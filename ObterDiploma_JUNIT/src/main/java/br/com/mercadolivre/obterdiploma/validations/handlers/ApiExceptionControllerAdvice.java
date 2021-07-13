package br.com.mercadolivre.obterdiploma.validations.handlers;

import br.com.mercadolivre.obterdiploma.validations.exceptions.ExceptionResponse;
import br.com.mercadolivre.obterdiploma.validations.exceptions.ValidationException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestControllerAdvice
public class ApiExceptionControllerAdvice {

    private final MessageSource messageSource;

    @Autowired
    public ApiExceptionControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationException> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ValidationException> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, Locale.ENGLISH);
            errors.add(new ValidationException(e.getField(), message));
        });

        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormatException.class)
    public ExceptionResponse handleInalidFormatException(InvalidFormatException exception){
        String field = exception.getPath().get(0).getFieldName();
        String value = (String) exception.getValue();

        return new ExceptionResponse("Valor " + value + "não é válido para o campo " + field);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ArithmeticException.class)
    public ExceptionResponse handleArithmeticException(ArithmeticException exception){
        return new ExceptionResponse(exception.getMessage());
    }
}
