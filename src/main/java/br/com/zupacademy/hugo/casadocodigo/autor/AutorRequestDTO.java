package br.com.zupacademy.hugo.casadocodigo.autor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class AutorRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
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
