package br.com.zupacademy.hugo.casadocodigo.config.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class TratamentoDeExcecoes {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ApiError> hanldeMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<ApiError> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();


        fieldErrors.forEach(fieldError -> {
            errors.add(new ApiError(
                    fieldError.getField(),
                    messageSource.getMessage(fieldError, LocaleContextHolder.getLocale())));
        });

        exception.getBindingResult().getGlobalErrors()
                .forEach(globalError -> {
                    errors.add(new ApiError(
                            globalError.getObjectName(),
                            messageSource.getMessage(globalError, LocaleContextHolder.getLocale())));
                });

        return errors;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String handleEntityNotFoundException(EntityNotFoundException exception) {
        return exception.getMessage();
    }

}
