package br.com.zupacademy.hugo.casadocodigo.util.validators;

import br.com.zupacademy.hugo.casadocodigo.cliente.NovoClienteRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class EstadoNaoNuloSeExistir implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoClienteRequestDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        NovoClienteRequestDTO requestDTO = (NovoClienteRequestDTO) target;
        Query query = entityManager.createQuery("SELECT 1 FROM Estado e where e.pais.id = :id");
        query.setParameter("id", requestDTO.getPaisId());
        List<?> lista = query.getResultList();

        if (requestDTO.getEstadoId() == null && !lista.isEmpty()){
            errors.rejectValue("estadoId", "404", "Existe um estado disponível para o país que você está cadastrando");
        }

    }
}
