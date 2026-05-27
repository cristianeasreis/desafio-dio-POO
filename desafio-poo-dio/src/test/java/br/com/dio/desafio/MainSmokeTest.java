package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;

public class MainSmokeTest {
    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.setTitulo("Java");
        curso.setDescricao("POO");
        curso.setCargaHoraria(5);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Teste");
        bootcamp.setDescricao("Descricao");
        bootcamp.getConteudos().add(curso);

        Dev dev = new Dev();
        dev.setNome("Teste");
        dev.inscreverBootcamp(bootcamp);
        dev.progredir();

        if (dev.getConteudosConcluidos().size() != 1) {
            throw new IllegalStateException("Teste falhou. Conteudo concluido nao foi registrado.");
        }

        if (dev.calcularTotalXp() <= 0) {
            throw new IllegalStateException("Teste falhou. XP deveria ser maior que zero.");
        }

        System.out.println("Smoke test OK");
    }
}

