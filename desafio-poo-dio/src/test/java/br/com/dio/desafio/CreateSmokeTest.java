package br.com.dio.desafio;

import br.com.dio.desafio.createupdatedelete.ConteudoService;
import br.com.dio.desafio.createupdatedelete.RegistroConteudo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CreateSmokeTest {
    public static void main(String[] args) {
        ConteudoService service = new ConteudoService();

        UUID cursoId = service.criarCurso("Java", "POO", 8);
        UUID mentoriaId = service.criarMentoria("Mentoria", "Carreira", LocalDate.now());

        List<RegistroConteudo> lista = service.listar();
        if (lista.size() != 2 || service.total() != 2) {
            throw new IllegalStateException("Create falhou: total esperado 2.");
        }

        Optional<RegistroConteudo> curso = service.buscarPorId(cursoId);
        Optional<RegistroConteudo> mentoria = service.buscarPorId(mentoriaId);
        if (curso.isEmpty() || mentoria.isEmpty()) {
            throw new IllegalStateException("Create falhou: nao encontrou registro por ID.");
        }

        System.out.println("Create smoke test OK");
    }
}



