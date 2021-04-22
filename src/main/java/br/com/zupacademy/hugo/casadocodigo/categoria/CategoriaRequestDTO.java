package br.com.zupacademy.hugo.casadocodigo.categoria;

import br.com.zupacademy.hugo.casadocodigo.util.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CategoriaRequestDTO {

    @NotBlank
    @UniqueValue(targetClass = Categoria.class, fieldName = "nome")
    private String nome;

    @JsonCreator
    public CategoriaRequestDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
