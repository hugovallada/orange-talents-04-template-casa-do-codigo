package br.com.zupacademy.hugo.casadocodigo.util.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistIdValidation.class)
public @interface ExistId {
    Class<?> targetClass();

    String fieldName();

    String message() default "O valor não existe no banco de dados";

    Class<?> [] groups() default {};

    public abstract Class<? extends Payload> [] payload() default {};
}
