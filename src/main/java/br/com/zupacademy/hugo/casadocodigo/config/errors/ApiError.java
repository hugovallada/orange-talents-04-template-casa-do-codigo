package br.com.zupacademy.hugo.casadocodigo.config.errors;

public class ApiError {

    String campo;

    String mensagem;

    public ApiError(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
