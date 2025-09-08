package com.example.estagiarios.base.ComSeparacaoParadigEDeclarativo.POO.Impel;

import java.util.HashMap;
import java.util.Map;

import com.example.estagiarios.base.ComSeparacaoParadigEDeclarativo.POO.Abs.IAvaliador;


public class AvaliadorAlunos implements IAvaliador {

    private Map<String, Double> alunos = new HashMap<>();

    private double media = 0.0;

    private Map<String, Double> recuperacao = new HashMap<>();
    private Map<String, Double> mediaAlunos = new HashMap<>();
    private Map<String, Double> premio = new HashMap<>();

    public AvaliadorAlunos() {
        alunos.put("Ana", 1.0);
        alunos.put("Bruno", 3.0);
        alunos.put("Carlos", 5.0);
        alunos.put("Daniela", 7.0);
        alunos.put("Eduardo", 9.0);
        alunos.put("Fernanda", 2.0);
        alunos.put("Gustavo", 8.0);
        alunos.put("Helena", 4.0);
        alunos.put("Igor", 6.0);
        alunos.put("Julia", 10.0);
    }

    @Override
    public IAvaliador calcularMedia() {
        double soma = 0.0;
        int qtd = 0;

        for (String nome : alunos.keySet()) {
            soma += alunos.get(nome);
            qtd++;
        }

        this.media = qtd > 0 ? soma / qtd : 0.0;
        return this;
    }

    @Override
    public IAvaliador filtrarRecuperacao() {
        for (Map.Entry<String, Double> entry : alunos.entrySet()) {
            double nota = entry.getValue();
            if (nota > 5 && nota < 6) {
                recuperacao.put(entry.getKey(), nota);
            }
        }
        return this;
    }

    @Override
    public IAvaliador filtrarMedia() {
        for (Map.Entry<String, Double> entry : alunos.entrySet()) {
            double nota = entry.getValue();
            if (nota > 6 && nota < 8) {
                mediaAlunos.put(entry.getKey(), nota);
            }
        }
        return this;
    }

    @Override
    public IAvaliador filtrarPremio() {
        for (Map.Entry<String, Double> entry : alunos.entrySet()) {
            double nota = entry.getValue();
            if (nota > 8) {
                premio.put(entry.getKey(), nota);
            }
        }
        return this;
    }

    @Override
    public void imprimirResultado() {
        System.out.println("Média geral: " + media);
        System.out.println("Alunos em recuperação: " + recuperacao);
        System.out.println("Alunos medianos: " + mediaAlunos);
        System.out.println("Alunos com prêmio: " + premio);
    }
}
