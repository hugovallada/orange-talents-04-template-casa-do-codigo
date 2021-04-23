package br.com.zupacademy.hugo.casadocodigo.cliente;

import br.com.zupacademy.hugo.casadocodigo.estado.Estado;
import br.com.zupacademy.hugo.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private @Email @NotBlank String email;

    private @NotBlank String nome;

    private @NotBlank String sobrenome;

    private @NotBlank String documento;

    private @NotBlank String endereco;

    private @NotBlank String complemento;

    private @NotBlank String cidade;

    private @NotNull @ManyToOne Pais pais;

    private @ManyToOne Estado estado;

    private @NotBlank String telefone;

    private @NotBlank String cep;

    public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                   @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                   @NotBlank String cidade, @NotNull Pais pais, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
