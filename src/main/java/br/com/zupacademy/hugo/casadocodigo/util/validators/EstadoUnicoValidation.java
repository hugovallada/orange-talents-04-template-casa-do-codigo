package br.com.zupacademy.hugo.casadocodigo.util.validators;



import br.com.zupacademy.hugo.casadocodigo.estado.NovoEstadoRequestDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoUnicoValidation implements ConstraintValidator<EstadoUnico, NovoEstadoRequestDTO> {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(EstadoUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(NovoEstadoRequestDTO value, ConstraintValidatorContext context) {
         Query query = entityManager.createQuery("SELECT 1 from Estado e WHERE e.nome = :nome AND e.pais.id = :id" );
         query.setParameter("nome",value.getNome());
         query.setParameter("id", value.getPaisId());

         List<?> listaResultado  = query.getResultList();

         return listaResultado.isEmpty();
    }
}
