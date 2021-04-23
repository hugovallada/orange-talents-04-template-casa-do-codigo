package br.com.zupacademy.hugo.casadocodigo.pais;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String cadastrarPais(@RequestBody @Valid NovoPaisRequestDTO novoPaisDto){
        Pais pais = novoPaisDto.toModel();
        entityManager.persist(pais);
        return pais.toString();
    }
}
