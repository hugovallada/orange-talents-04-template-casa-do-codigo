package br.com.zupacademy.hugo.casadocodigo.livro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String criarLivro(@RequestBody @Valid LivroRequestDTO livroRequestDTO){
        Livro livro = livroRequestDTO.toModel(entityManager);
        entityManager.persist(livro);
        return livro.toString();
    }
}
