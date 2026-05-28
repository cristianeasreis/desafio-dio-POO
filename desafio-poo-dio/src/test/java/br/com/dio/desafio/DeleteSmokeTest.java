package br.com.dio.desafio;

import br.com.dio.desafio.createupdatedelete.ConteudoService;

import java.time.LocalDate;
import java.util.UUID;

public class DeleteSmokeTest {
    public static void main(String[] args) {
        ConteudoService service = new ConteudoService();

        UUID cursoId = service.criarCurso("Java", "POO", 8);
        UUID mentoriaId = service.criarMentoria("Mentoria", "Carreira", LocalDate.now());

        boolean removeuCurso = service.remover(cursoId);
        boolean removeuMentoria = service.remover(mentoriaId);

        if (!removeuCurso || !removeuMentoria) {
            throw new IllegalStateException("Delete falhou: nao removeu os registros esperados.");
        }

        if (service.total() != 0) {
            throw new IllegalStateException("Delete falhou: total esperado 0 apos remocao.");
        }

        if (service.remover(cursoId)) {
            throw new IllegalStateException("Delete falhou: removeu item inexistente.");
        }

        System.out.println("Delete smoke test OK");
    }
}

