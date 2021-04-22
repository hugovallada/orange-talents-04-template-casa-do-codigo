package br.com.zupacademy.hugo.casadocodigo.livro;

public class ListagemInfoLivroResponseDTO {

    private Long id;

    private String titulo;

    public ListagemInfoLivroResponseDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
