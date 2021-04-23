package br.com.zupacademy.hugo.casadocodigo.util.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EstadoUnicoValidation.class)
public @interface EstadoUnico {

    String message() default "Já existe um estado com esse nome, neste país";

    Class<?> [] groups() default {};

    public abstract Class<? extends Payload> [] payload() default {};

}
