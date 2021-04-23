package br.com.zupacademy.hugo.casadocodigo.estado;

import br.com.zupacademy.hugo.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    /**
     * @deprecated Construtor de uso exclusivo da JPA
     */
    @Deprecated
    public Estado(){}

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }

    public boolean pertenceAoPais(Pais pais){
        return pais == this.pais;
    }
}
