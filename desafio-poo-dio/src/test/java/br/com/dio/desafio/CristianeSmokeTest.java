package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;

public class CristianeSmokeTest {
    public static void main(String[] args) {
        Curso curso = new Curso("Java", "POO", 5);

        Bootcamp bootcamp = new Bootcamp("Bootcamp Cristiane", "Descricao");
        bootcamp.adicionarConteudo(curso);

        Dev dev = new Dev("Cristiane");
        dev.inscreverBootcamp(bootcamp);
        dev.progredir();

        if (dev.totalConteudosConcluidos() != 1) {
            throw new IllegalStateException("Teste falhou para Cristiane. Conteudo concluido nao foi registrado.");
        }

        if (dev.calcularTotalXp() <= 0) {
            throw new IllegalStateException("Teste falhou para Cristiane. XP deveria ser maior que zero.");
        }

        System.out.println("Smoke test Cristiane OK");
    }
}

