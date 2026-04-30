package com.quadras.agendamento.repository;

import com.quadras.agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.time.LocalDateTime;




public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByQuadraIdAndDataHora(Long quadraId, LocalDateTime dataHora);
    List<Agendamento> findByQuadraId(Long quadraId);
}