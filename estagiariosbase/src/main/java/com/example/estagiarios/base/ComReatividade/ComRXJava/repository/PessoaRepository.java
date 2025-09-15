package com.example.estagiarios.base.ComReatividade.ComRXJava.repository;

import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.core.Observable;

import com.example.estagiarios.base.ComReatividade.ComRXJava.model.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PessoaRepository {
    private final Map<Long, Pessoa> banco = new ConcurrentHashMap<>();

    public Single<Pessoa> salvar(Pessoa pessoa) {
        return Single.fromCallable(() -> {
            banco.put(pessoa.getId(), pessoa);
            return pessoa;
        });
    }

    public Maybe<Pessoa> buscarPorId(Long id) {
        return Maybe.create(emitter -> {
            Pessoa pessoa = banco.get(id);
            if (pessoa != null) {
                emitter.onSuccess(pessoa);
            } else {
                emitter.onComplete(); // Não encontrado
            }
        });
    }

    public Observable<Pessoa> listarTodas() {
        return Observable.fromIterable(banco.values());
    }

    public Completable deletar(Long id) {
        return Completable.fromAction(() -> {
            banco.remove(id);
        });
    }

    public Single<Pessoa> atualizar(Long id, Pessoa novaPessoa) {
        return Single.fromCallable(() -> {
            if (banco.containsKey(id)) {
                banco.put(id, novaPessoa);
                return novaPessoa;
            } else {
                throw new NoSuchElementException("Pessoa não encontrada para atualização");
            }
        });
    }
}