package br.com.zupacademy.hugo.casadocodigo.util.validators;

import br.com.zupacademy.hugo.casadocodigo.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return autorRepository.findByEmail(email).isEmpty();
    }
}
