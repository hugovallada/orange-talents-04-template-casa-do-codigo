package br.com.zupacademy.hugo.casadocodigo.pais;

import br.com.zupacademy.hugo.casadocodigo.util.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequestDTO {

    @NotBlank
    @UniqueValue(targetClass = Pais.class, fieldName = "nome")
    private String nome;


    @JsonCreator
    public NovoPaisRequestDTO(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Pais toModel(){
        return new Pais(nome);
    }
}
