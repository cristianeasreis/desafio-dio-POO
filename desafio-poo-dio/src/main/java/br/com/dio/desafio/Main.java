package br.com.dio.desafio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso cursoJava = new Curso("Curso Java", "Aprenda os fundamentos de Java e POO", 8);

        Curso cursoJs = new Curso("Curso JavaScript", "Conceitos iniciais de JavaScript", 4);

        Mentoria mentoria = new Mentoria("Mentoria de Carreira", "Dicas para evoluir como dev", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp GFT Java", "Bootcamp para acelerar sua jornada Java");
        bootcamp.adicionarConteudo(cursoJava);
        bootcamp.adicionarConteudo(cursoJs);
        bootcamp.adicionarConteudo(mentoria);

        Dev cristiane = new Dev("Cristiane");
        cristiane.inscreverBootcamp(bootcamp);
        cristiane.progredir();
        cristiane.progredir();

        System.out.println("Dev: " + cristiane.nome());
        System.out.println("Concluidos: " + cristiane.totalConteudosConcluidos());
        System.out.println("Inscritos: " + cristiane.totalConteudosInscritos());
        System.out.println("XP total: " + cristiane.calcularTotalXp());
    }
}
