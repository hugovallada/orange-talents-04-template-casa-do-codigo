package br.com.zupacademy.hugo.casadocodigo.categoria;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String criarCategoria (@RequestBody @Valid CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = new Categoria(categoriaRequestDTO.getNome());
        entityManager.persist(categoria);
        return categoria.toString();
    }
}
