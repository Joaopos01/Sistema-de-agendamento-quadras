package com.quadras.agendamento.service;

import com.quadras.agendamento.model.Agendamento;
import com.quadras.agendamento.model.Quadra;
import com.quadras.agendamento.model.Usuario;
import com.quadras.agendamento.repository.AgendamentoRepository;
import com.quadras.agendamento.repository.QuadraRepository;
import com.quadras.agendamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final QuadraRepository quadraRepository;

    public AgendamentoService(
            AgendamentoRepository agendamentoRepository,
            UsuarioRepository usuarioRepository,
            QuadraRepository quadraRepository
    ) {
        this.agendamentoRepository = agendamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.quadraRepository = quadraRepository;
    }

    public Agendamento salvar(Long usuarioId, Long quadraId, Agendamento agendamento) {

        if (agendamento.getDataHora() == null) {
            throw new RuntimeException("Data e hora são obrigatórias");
        }

        if (agendamentoRepository.existsByQuadraIdAndDataHora(quadraId, agendamento.getDataHora())) {
            throw new RuntimeException("Horário já reservado para essa quadra");
        }

        if (agendamento.getDataHora().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Não é possível agendar um horário no passado");
        }

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Quadra quadra = quadraRepository.findById(quadraId)
                .orElseThrow(() -> new RuntimeException("Quadra não encontrada"));

        agendamento.setUsuario(usuario);
        agendamento.setQuadra(quadra);

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listar() {
        return agendamentoRepository.findAll();
    }

    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }
}

