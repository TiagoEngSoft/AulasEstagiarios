package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj01.repository;

import java.util.*;

import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj01.model.*;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj01.observer.*;

public class PessoaRepository {
    private final Map<Long, Pessoa> banco = new HashMap<>();
    private final List<PessoaObserver> observers = new ArrayList<>();

    public void adicionarObserver(PessoaObserver observer) {
        observers.add(observer);
    }

    private void notificarTodos(PessoaEvent evento) {
        for (PessoaObserver obs : observers) {
            obs.notificar(evento);
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
        return new ArrayList<>(banco.values());
    }
}
