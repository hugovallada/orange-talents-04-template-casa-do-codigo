package br.com.zupacademy.hugo.casadocodigo.autor;

import br.com.zupacademy.hugo.casadocodigo.util.validators.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(targetClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequestDTO(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel(){
        return new Autor(nome, email, descricao);
    }
}
