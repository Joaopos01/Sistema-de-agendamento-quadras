package com.quadras.agendamento.service;

import com.quadras.agendamento.model.Quadra;
import com.quadras.agendamento.repository.QuadraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuadraService {

    private final QuadraRepository repository;

    public QuadraService(QuadraRepository repository) {
        this.repository = repository;
    }

    public Quadra salvar(Quadra quadra) {
        return repository.save(quadra);
    }

    public List<Quadra> listar() {
        return repository.findAll();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}