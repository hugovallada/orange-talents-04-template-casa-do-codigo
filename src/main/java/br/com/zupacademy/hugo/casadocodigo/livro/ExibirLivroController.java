package br.com.zupacademy.hugo.casadocodigo.livro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class ExibirLivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public List<ListagemInfoLivroResponseDTO> listarInfoLivros(){
        Query query = entityManager.createQuery("Select l from Livro l");
        List<Livro> livros = query.getResultList();

        return livros.stream().map(ListagemInfoLivroResponseDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DetalheLivroResponseDTO buscarLivroPorId(@PathVariable Long id){
        Livro livro = entityManager.find(Livro.class, id);

        if (livro == null) {
            throw new EntityNotFoundException("Não foi possível encontrar um livro com o id " + id);
        }

        return new DetalheLivroResponseDTO(livro);
    }

}
