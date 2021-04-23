package br.com.zupacademy.hugo.casadocodigo.cliente;

public class ClienteIdResponseDTO {

    private Long id;

    public ClienteIdResponseDTO(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
