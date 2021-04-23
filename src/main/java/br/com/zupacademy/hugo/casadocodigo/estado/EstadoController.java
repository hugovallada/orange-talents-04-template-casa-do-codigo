package br.com.zupacademy.hugo.casadocodigo.estado;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String cadastrarEstado(@RequestBody @Valid NovoEstadoRequestDTO novoEstadoDto){
        Estado estado = novoEstadoDto.toModel(entityManager);
        entityManager.persist(estado);
        return estado.toString();
    }
}
