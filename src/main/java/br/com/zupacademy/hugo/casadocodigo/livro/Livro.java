package br.com.zupacademy.hugo.casadocodigo.livro;

import br.com.zupacademy.hugo.casadocodigo.autor.Autor;
import br.com.zupacademy.hugo.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
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
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @ManyToOne
    @Valid
    private Categoria categoria;

    @ManyToOne
    @Valid
    private Autor autor;

    /**
     * @deprecated Construtor de uso específico da Jpa
     */
    @Deprecated
    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas, String isbn, LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroDePaginas=" + numeroDePaginas +
                ", isbn='" + isbn + '\'' +
                ", dataDePublicacao=" + dataDePublicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
