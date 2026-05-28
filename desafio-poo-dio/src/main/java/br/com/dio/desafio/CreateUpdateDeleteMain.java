package br.com.dio.desafio;

import br.com.dio.desafio.createupdatedelete.ConteudoService;
import br.com.dio.desafio.createupdatedelete.RegistroConteudo;

import java.time.LocalDate;
import java.util.UUID;

public class CreateUpdateDeleteMain {
    public static void main(String[] args) {
        ConteudoService service = new ConteudoService();

        UUID cursoId = service.criarCurso("Java Basico", "POO e fundamentos", 8);
        UUID mentoriaId = service.criarMentoria("Mentoria de Carreira", "Plano de evolucao", LocalDate.now());

        System.out.println("== LISTA INICIAL ==");
        for (RegistroConteudo item : service.listar()) {
            System.out.println(item.id() + " -> " + item.conteudo());
        }

        service.atualizarCurso(cursoId, "Java Intermediario", "Colecoes e streams", 10);
        service.remover(mentoriaId);

        System.out.println("\n== APOS UPDATE/DELETE ==");
        service.buscarPorId(cursoId).ifPresent(item ->
                System.out.println(item.id() + " -> " + item.conteudo())
        );
        System.out.println("Total de registros: " + service.total());
    }
}



