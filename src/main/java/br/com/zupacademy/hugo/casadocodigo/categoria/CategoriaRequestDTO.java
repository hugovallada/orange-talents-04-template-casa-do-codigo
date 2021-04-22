package br.com.zupacademy.hugo.casadocodigo.categoria;

import br.com.zupacademy.hugo.casadocodigo.util.validators.UniqueNome;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CategoriaRequestDTO {

    @NotBlank
    @UniqueNome
    private String nome;

    @JsonCreator
    public CategoriaRequestDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
