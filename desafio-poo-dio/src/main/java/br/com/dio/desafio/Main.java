package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Curso Java");
        cursoJava.setDescricao("Aprenda os fundamentos de Java e POO");
        cursoJava.setCargaHoraria(8);

        Curso cursoJs = new Curso();
        cursoJs.setTitulo("Curso JavaScript");
        cursoJs.setDescricao("Conceitos iniciais de JavaScript");
        cursoJs.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Carreira");
        mentoria.setDescricao("Dicas para evoluir como dev");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp GFT Java");
        bootcamp.setDescricao("Bootcamp para acelerar sua jornada Java");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoJs);
        bootcamp.getConteudos().add(mentoria);

        Dev camila = new Dev();
        camila.setNome("Camila");
        camila.inscreverBootcamp(bootcamp);
        camila.progredir();
        camila.progredir();

        System.out.println("Dev: " + camila.getNome());
        System.out.println("Concluidos: " + camila.getConteudosConcluidos().size());
        System.out.println("Inscritos: " + camila.getConteudosInscritos().size());
        System.out.println("XP total: " + camila.calcularTotalXp());
    }
}
