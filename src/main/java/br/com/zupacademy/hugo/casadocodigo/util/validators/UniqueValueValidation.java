package br.com.zupacademy.hugo.casadocodigo.util.validators;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidation implements ConstraintValidator<UniqueValue, Object> {

    private String fiedlName;

    private Class<?> targetClass;

    @Autowired
    private EntityManager entityManager;


    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        fiedlName = constraintAnnotation.fieldName();
        targetClass = constraintAnnotation.targetClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("Select 1 from " + targetClass.getName() + " where " + fiedlName + " = :value");
        query.setParameter("value",value);
        List<?> listaExiste = query.getResultList();

        return listaExiste.size() < 1;
    }

}
