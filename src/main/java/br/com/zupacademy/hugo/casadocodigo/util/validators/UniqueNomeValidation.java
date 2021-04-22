package br.com.zupacademy.hugo.casadocodigo.util.validators;

import br.com.zupacademy.hugo.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNomeValidation implements ConstraintValidator<UniqueNome, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(UniqueNome constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext context) {
        return categoriaRepository.findByNome(nome).isEmpty();
    }
}
