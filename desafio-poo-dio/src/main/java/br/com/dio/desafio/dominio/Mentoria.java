package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Mentoria extends Conteudo {
    private String titulo;
    private String descricao;
    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mentoria mentoria = (Mentoria) o;
        return Objects.equals(titulo, mentoria.titulo)
                && Objects.equals(descricao, mentoria.descricao)
                && Objects.equals(data, mentoria.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao, data);
    }
}

