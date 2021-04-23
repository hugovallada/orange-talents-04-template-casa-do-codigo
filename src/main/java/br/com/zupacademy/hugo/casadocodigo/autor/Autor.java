package br.com.zupacademy.hugo.casadocodigo.autor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column(nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false, length = 400)
    @NotBlank
    @Size(max = 400)
    private String descricao;

    private LocalDateTime instanteRegistro = LocalDateTime.now();

    public Autor(
            @NotBlank String nome,
            @NotBlank @Email String email,
            @NotBlank @Size(max = 400) String descricao
    ) {

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    /**
     * @deprecated Construtor para uso exclusivo do JPA
     */
    @Deprecated
    public Autor() {
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", instanteRegistro=" + instanteRegistro +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
