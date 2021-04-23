package br.com.zupacademy.hugo.casadocodigo.autor;

public class DetalheAutorResponseDTO {

    private String nome;

    private String descricao;

    public DetalheAutorResponseDTO(Autor autor){
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
