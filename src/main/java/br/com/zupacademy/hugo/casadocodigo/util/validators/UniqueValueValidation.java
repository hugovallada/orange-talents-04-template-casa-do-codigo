package br.com.zupacademy.hugo.casadocodigo.util.validators;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidation implements ConstraintValidator<UniqueValue, Object> {

    private String fiedlName;

    private Class<?> targetClass;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        fiedlName = constraintAnnotation.fieldName();
        targetClass = constraintAnnotation.targetClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("Select 1 from " + targetClass.getName() +
                " where " + fiedlName + " = :value");

        query.setParameter("value",value);
        List<?> listaExiste = query.getResultList();

        Assert.state(listaExiste.size() <= 1,
                "Um erro grave aconteceu. Mais de um objeto do tipo " + targetClass.getName() +
                        " foi encontrado no banco com o campo " + fiedlName + " de valor " + value);
        return listaExiste.isEmpty();
    }

}
