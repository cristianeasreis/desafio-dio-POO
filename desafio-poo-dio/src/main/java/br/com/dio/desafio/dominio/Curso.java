package br.com.dio.desafio.dominio;

import java.util.Objects;

public class Curso extends Conteudo {

    private String titulo;
    private String descricao;
    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO + cargaHoraria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return cargaHoraria == curso.cargaHoraria
                && Objects.equals(titulo, curso.titulo)
                && Objects.equals(descricao, curso.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao, cargaHoraria);
    }
}
