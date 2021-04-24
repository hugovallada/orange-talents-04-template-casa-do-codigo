package br.com.zupacademy.hugo.casadocodigo.livro;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
