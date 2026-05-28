package br.com.dio.desafio.createupdatedelete;

import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ConteudoService {
    private final Map<UUID, Conteudo> banco = new LinkedHashMap<>();

    public UUID criarCurso(String titulo, String descricao, int cargaHoraria) {
        UUID id = UUID.randomUUID();
        banco.put(id, new Curso(titulo, descricao, cargaHoraria));
        return id;
    }

    public UUID criarMentoria(String titulo, String descricao, LocalDate data) {
        UUID id = UUID.randomUUID();
        banco.put(id, new Mentoria(titulo, descricao, data));
        return id;
    }

    public List<RegistroConteudo> listar() {
        List<RegistroConteudo> registros = new ArrayList<>();
        for (Map.Entry<UUID, Conteudo> item : banco.entrySet()) {
            registros.add(new RegistroConteudo(item.getKey(), item.getValue()));
        }
        return registros;
    }

    public Optional<RegistroConteudo> buscarPorId(UUID id) {
        Conteudo conteudo = banco.get(id);
        if (conteudo == null) {
            return Optional.empty();
        }
        return Optional.of(new RegistroConteudo(id, conteudo));
    }

    public boolean atualizarCurso(UUID id, String titulo, String descricao, int cargaHoraria) {
        Conteudo atual = banco.get(id);
        if (!(atual instanceof Curso)) {
            return false;
        }
        banco.put(id, new Curso(titulo, descricao, cargaHoraria));
        return true;
    }

    public boolean atualizarMentoria(UUID id, String titulo, String descricao, LocalDate data) {
        Conteudo atual = banco.get(id);
        if (!(atual instanceof Mentoria)) {
            return false;
        }
        banco.put(id, new Mentoria(titulo, descricao, data));
        return true;
    }

    public boolean remover(UUID id) {
        return banco.remove(id) != null;
    }

    public int total() {
        return banco.size();
    }
}



