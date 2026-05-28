package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;

public class IsraelSmokeTest {
    public static void main(String[] args) {
        Curso curso = new Curso("Java", "POO", 5);

        Bootcamp bootcamp = new Bootcamp("Bootcamp Israel", "Descricao");
        bootcamp.adicionarConteudo(curso);

        Dev dev = new Dev("Israel");
        dev.inscreverBootcamp(bootcamp);
        dev.progredir();

        if (dev.totalConteudosConcluidos() != 1) {
            throw new IllegalStateException("Teste falhou para Israel. Conteudo concluido nao foi registrado.");
        }

        if (dev.calcularTotalXp() <= 0) {
            throw new IllegalStateException("Teste falhou para Israel. XP deveria ser maior que zero.");
        }

        System.out.println("Smoke test Israel OK");
    }
}

