package com.quadras.agendamento.model;

import jakarta.persistence.*;

@Entity
public class Quadra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String localizacao;
    private Double precoHora;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public Double getPrecoHora() {
        return precoHora;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }
}