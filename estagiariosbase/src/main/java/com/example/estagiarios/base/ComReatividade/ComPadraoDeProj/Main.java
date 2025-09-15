package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj;

import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.model.*;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.repository.*;

public class Main {
    public static void main(String[] args) {
        PessoaRepository repo = new PessoaRepository();

        // Adicionando um observer que reage aos eventos
        repo.adicionarObserver(evento -> {
            switch (evento.getTipo()) {
                case CRIADA:
                    System.out.println("[Observer] Pessoa criada: " + evento.getPessoa());
                    break;
                case ATUALIZADA:
                    System.out.println("[Observer] Pessoa atualizada: " + evento.getPessoa());
                    break;
                case DELETADA:
                    System.out.println("[Observer] Pessoa deletada: " + evento.getPessoa());
                    break;
            }
        });

        // Executando operações CRUD
        //Cadastro
        Pessoa p1 = new Pessoa(1L, "Alice");
        repo.criar(p1);

        Pessoa p2 = new Pessoa(2L, "Bob");
        repo.criar(p2);

        Pessoa p3 = new Pessoa(3L, "Belmiro");
        repo.criar(p3);

        //Leitura
        System.out.println("\nTodas as pessoas:");
        repo.listar().forEach(System.out::println);
        System.out.println("\n");
        
        //Atualizacao
        repo.atualizar(1L, "Alicia");
        
        //Delecao
        repo.deletar(2L);
        
        //Leitura
        System.out.println("\nTodas as pessoas:");
        repo.listar().forEach(System.out::println);
    }
}
