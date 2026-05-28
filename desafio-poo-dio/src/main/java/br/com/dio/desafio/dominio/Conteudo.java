package br.com.dio.desafio.dominio;

import java.util.Objects;

public abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;

    protected final String titulo;
    protected final String descricao;

    protected Conteudo(String titulo, String descricao) {
        this.titulo = validarTextoObrigatorio(titulo, "titulo");
        this.descricao = validarTextoObrigatorio(descricao, "descricao");
    }

    public abstract double calcularXp();

    private String validarTextoObrigatorio(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("O campo '" + campo + "' e obrigatorio.");
        }
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Conteudo conteudo = (Conteudo) o;
        return Objects.equals(titulo, conteudo.titulo)
                && Objects.equals(descricao, conteudo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{titulo='" + titulo + "', descricao='" + descricao + "'}";
    }
}
