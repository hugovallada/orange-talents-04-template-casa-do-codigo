package br.com.zupacademy.hugo.casadocodigo.estado;

import br.com.zupacademy.hugo.casadocodigo.pais.Pais;
import br.com.zupacademy.hugo.casadocodigo.util.validators.EstadoUnico;
import br.com.zupacademy.hugo.casadocodigo.util.validators.ExistId;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoUnico
public class NovoEstadoRequestDTO {

    @NotNull
    @ExistId(targetClass = Pais.class, fieldName = "id")
    private Long paisId;

    @NotBlank
    private String nome;

    public NovoEstadoRequestDTO(Long paisId, String nome) {
        this.paisId = paisId;
        this.nome = nome;
    }

    public Estado toModel(EntityManager entityManager){
        @NotNull Pais pais = entityManager.find(Pais.class, paisId);

        Assert.state(pais != null, "O país com o id " + paisId + " não foi encontrado");
        return new Estado(nome, pais);
    }

    public Long getPaisId() {
        return paisId;
    }

    public String getNome() {
        return nome;
    }
}