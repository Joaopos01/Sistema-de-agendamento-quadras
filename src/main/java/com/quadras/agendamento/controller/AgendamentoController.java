package com.quadras.agendamento.controller;

import com.quadras.agendamento.model.Agendamento;
import com.quadras.agendamento.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    public Agendamento salvar(
            @RequestParam Long usuarioId,
            @RequestParam Long quadraId,
            @RequestBody Agendamento agendamento
    ) {
        return service.salvar(usuarioId, quadraId, agendamento);
    }

    @GetMapping
    public List<Agendamento> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}