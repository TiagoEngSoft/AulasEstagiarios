package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.repository;

import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.events.PessoaEvent;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.model.*;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.observers.*;

import java.util.*;

public class GerenciadorEventosPessoasPub {
    private final Map<Long, Pessoa> banco = new HashMap<>();
    private final List<Listner> observersPessoa = new ArrayList<>();

    public void adicionarObservers(List<Listner> observadores) {
        for (Listner obs : observadores) {
            observersPessoa.add(obs);
        }
    }

    private void notificarTodos(PessoaEvent evento) {
        for (Listner obs : observersPessoa) {
            obs.novaNotificacao(evento);
        }
    }

    public void criar(Pessoa pessoa) {
        banco.put(pessoa.getId(), pessoa);
        notificarTodos(new PessoaEvent(PessoaEvent.Tipo.CRIADA, pessoa));
    }

    public Pessoa buscar(Long id) {
        return banco.get(id);
    }

    public void atualizar(Long id, String novoNome) {
        Pessoa p = banco.get(id);
        if (p != null) {
            p.setNome(novoNome);
            notificarTodos(new PessoaEvent(PessoaEvent.Tipo.ATUALIZADA, p));
        }
    }

    public void deletar(Long id) {
        Pessoa p = banco.remove(id);
        if (p != null) {
            notificarTodos(new PessoaEvent(PessoaEvent.Tipo.DELETADA, p));
        }
    }

    public List<Pessoa> listar() {
        System.out.println("\nTodas as pessoas:");
        return new ArrayList<>(banco.values());
    }
}
