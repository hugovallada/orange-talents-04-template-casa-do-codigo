package br.com.zupacademy.hugo.casadocodigo.livro;

import br.com.zupacademy.hugo.casadocodigo.autor.Autor;
import br.com.zupacademy.hugo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.hugo.casadocodigo.util.validators.ExistId;
import br.com.zupacademy.hugo.casadocodigo.util.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequestDTO {


    @NotBlank
    @UniqueValue(targetClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    @UniqueValue(targetClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotNull
    @ExistId(targetClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    @NotNull
    @ExistId(targetClass = Autor.class, fieldName = "id")
    private Long autorId;

    public LivroRequestDTO(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas, String isbn, @JsonProperty("dataDePublicacao") LocalDate dataDePublicacao, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public Livro toModel(EntityManager entityManager){
       @NotNull Categoria categoria = entityManager.find(Categoria.class, categoriaId);
       @NotNull Autor autor = entityManager.find(Autor.class, autorId);

        Assert.state(autor != null, "Você está querendo cadastrar um livro para um autor que não existe");
        Assert.state(categoria != null, "Você está querendo cadastrar um livro para uma categoria que não existe");

        return new Livro(titulo, resumo,sumario, preco, numeroDePaginas, isbn, dataDePublicacao, categoria, autor);
    }

}
