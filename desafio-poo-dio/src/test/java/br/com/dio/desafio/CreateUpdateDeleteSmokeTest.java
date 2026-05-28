package br.com.dio.desafio;

import br.com.dio.desafio.createupdatedelete.ConteudoService;

import java.time.LocalDate;
import java.util.UUID;

public class CreateUpdateDeleteSmokeTest {
    public static void main(String[] args) {
        ConteudoService service = new ConteudoService();

        UUID cursoId = service.criarCurso("Java", "POO", 5);
        UUID mentoriaId = service.criarMentoria("Mentoria", "Carreira", LocalDate.now());

        if (service.total() != 2) {
            throw new IllegalStateException("Teste create falhou no create/list.");
        }

        boolean atualizou = service.atualizarCurso(cursoId, "Java Avancado", "POO e Streams", 8);
        if (!atualizou) {
            throw new IllegalStateException("Teste update falhou no update.");
        }

        boolean removeu = service.remover(mentoriaId);
        if (!removeu || service.total() != 1) {
            throw new IllegalStateException("Teste delete falhou no delete.");
        }

        System.out.println("Create/Update/Delete smoke test OK");
    }
}



