package br.com.dio.desafio.createupdatedelete;

import br.com.dio.desafio.dominio.Conteudo;

import java.util.UUID;

public class RegistroConteudo {
    private final UUID id;
    private final Conteudo conteudo;

    public RegistroConteudo(UUID id, Conteudo conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public UUID id() {
        return id;
    }

    public Conteudo conteudo() {
        return conteudo;
    }
}


