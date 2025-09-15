package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.model;

public class Pessoa {
    private Long id;
    private String nome;

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome='" + nome + "'}";
    }
}
