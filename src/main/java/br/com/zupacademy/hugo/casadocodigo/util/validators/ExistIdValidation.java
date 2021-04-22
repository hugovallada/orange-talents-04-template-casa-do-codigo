package br.com.zupacademy.hugo.casadocodigo.util.validators;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidation implements ConstraintValidator<ExistId, Long> {

    private String fieldName;

    private Class<?> targetClass;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void initialize(ExistId constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
        targetClass = constraintAnnotation.targetClass();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("Select 1 from " + targetClass.getName() + " where " + fieldName + " = :value");
        query.setParameter("value", value);
        List<?> listaExiste = query.getResultList();

        Assert.state(listaExiste.size() <= 1, "Um erro aconteceu, você tem ids iguais no seu banco");

        return !listaExiste.isEmpty();
    }
}
