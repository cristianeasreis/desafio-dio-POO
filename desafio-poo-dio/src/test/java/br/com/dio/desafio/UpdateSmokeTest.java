package br.com.dio.desafio;

import br.com.dio.desafio.createupdatedelete.ConteudoService;
import br.com.dio.desafio.createupdatedelete.RegistroConteudo;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class UpdateSmokeTest {
    public static void main(String[] args) {
        ConteudoService service = new ConteudoService();

        UUID cursoId = service.criarCurso("Java Basico", "POO", 5);
        UUID mentoriaId = service.criarMentoria("Mentoria Inicial", "Carreira", LocalDate.now());

        boolean atualizouCurso = service.atualizarCurso(cursoId, "Java Intermediario", "Colecoes", 10);
        boolean atualizouMentoria = service.atualizarMentoria(mentoriaId, "Mentoria Avancada", "Plano Senior", LocalDate.now().plusDays(1));

        if (!atualizouCurso || !atualizouMentoria) {
            throw new IllegalStateException("Update falhou: nao atualizou curso/mentoria.");
        }

        Optional<RegistroConteudo> cursoAtualizado = service.buscarPorId(cursoId);
        Optional<RegistroConteudo> mentoriaAtualizada = service.buscarPorId(mentoriaId);

        if (cursoAtualizado.isEmpty() || mentoriaAtualizada.isEmpty()) {
            throw new IllegalStateException("Update falhou: item atualizado nao encontrado.");
        }

        if (!cursoAtualizado.get().conteudo().toString().contains("Java Intermediario")) {
            throw new IllegalStateException("Update falhou: curso nao refletiu novo valor.");
        }

        if (!mentoriaAtualizada.get().conteudo().toString().contains("Mentoria Avancada")) {
            throw new IllegalStateException("Update falhou: mentoria nao refletiu novo valor.");
        }

        System.out.println("Update smoke test OK");
    }
}



