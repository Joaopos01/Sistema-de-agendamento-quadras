package com.quadras.agendamento.repository;

import com.quadras.agendamento.model.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuadraRepository extends JpaRepository<Quadra, Long> {
}