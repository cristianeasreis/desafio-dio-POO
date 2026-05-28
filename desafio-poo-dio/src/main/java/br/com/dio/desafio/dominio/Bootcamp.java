package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private final String nome;
    private final String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private final Set<Dev> devsInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.nome = validarTextoObrigatorio(nome, "nome");
        this.descricao = validarTextoObrigatorio(descricao, "descricao");
    }

    public void adicionarConteudo(Conteudo conteudo) {
        Objects.requireNonNull(conteudo, "O conteudo nao pode ser nulo.");
        conteudos.add(conteudo);
    }

    public Set<Conteudo> conteudosDisponiveis() {
        return Collections.unmodifiableSet(conteudos);
    }

    public int totalDevsInscritos() {
        return devsInscritos.size();
    }

    void registrarDev(Dev dev) {
        Objects.requireNonNull(dev, "O dev nao pode ser nulo.");
        devsInscritos.add(dev);
    }

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
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome)
                && Objects.equals(descricao, bootcamp.descricao)
                && Objects.equals(dataInicial, bootcamp.dataInicial)
                && Objects.equals(dataFinal, bootcamp.dataFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal);
    }
}
