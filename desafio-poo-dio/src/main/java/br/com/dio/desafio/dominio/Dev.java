package br.com.dio.desafio.dominio;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Dev {
    private final String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do dev e obrigatorio.");
        }
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        Objects.requireNonNull(bootcamp, "O bootcamp nao pode ser nulo.");
        conteudosInscritos.addAll(bootcamp.conteudosDisponiveis());
        bootcamp.registrarDev(this);
    }

    public boolean progredir() {
        Iterator<Conteudo> iterator = conteudosInscritos.iterator();
        if (!iterator.hasNext()) {
            return false;
        }
        Conteudo conteudo = iterator.next();
        iterator.remove();
        conteudosConcluidos.add(conteudo);
        return true;
    }

    public double calcularTotalXp() {
        return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String nome() {
        return nome;
    }

    public int totalConteudosInscritos() {
        return conteudosInscritos.size();
    }

    public int totalConteudosConcluidos() {
        return conteudosConcluidos.size();
    }

    public Set<Conteudo> conteudosInscritos() {
        return Collections.unmodifiableSet(conteudosInscritos);
    }

    public Set<Conteudo> conteudosConcluidos() {
        return Collections.unmodifiableSet(conteudosConcluidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
