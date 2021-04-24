package br.com.zupacademy.hugo.casadocodigo.cliente;

import br.com.zupacademy.hugo.casadocodigo.estado.Estado;
import br.com.zupacademy.hugo.casadocodigo.pais.Pais;
import br.com.zupacademy.hugo.casadocodigo.util.validators.UniqueValue;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoClienteRequestDTO {

    @UniqueValue(targetClass = Cliente.class, fieldName = "email")
    private @NotBlank @Email String email;

    private @NotBlank String nome;

    private @NotBlank String sobrenome;

    @UniqueValue(targetClass = Cliente.class, fieldName = "documento")
    private @NotBlank String documento;

    private @NotBlank String endereco;

    private @NotBlank String complemento;

    private @NotBlank String cidade;

    private @NotNull Long paisId;

    private Long estadoId;

    private @NotBlank String telefone;

    private @NotBlank String cep;

    public NovoClienteRequestDTO(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long paisId, Long estadoId, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toCliente(EntityManager entityManager){
       @NotNull Pais pais = entityManager.find(Pais.class, paisId);
       Estado estado = estadoId != null ? entityManager.find(Estado.class, estadoId) : null;

       Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);

       if(estado != null){
           cliente.setEstado(estado);
       }

       return cliente;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Long getPaisId() {
        return paisId;
    }

    public boolean documentoValido(){
        Assert.hasLength(documento, "Não deve validar o documento se ele não estiver preenchido");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
    }
}

