package com.quadras.agendamento.controller;

import com.quadras.agendamento.model.Quadra;
import com.quadras.agendamento.service.QuadraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quadras")
public class QuadraController {

    private final QuadraService service;

    public QuadraController(QuadraService service) {
        this.service = service;
    }

    @PostMapping
    public Quadra salvar(@RequestBody Quadra quadra) {
        return service.salvar(quadra);
    }

    @GetMapping
    public List<Quadra> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}