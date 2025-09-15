package com.example.estagiarios.base.ComReatividade.ComRXJava.service;

import io.reactivex.rxjava3.core.*;
import com.example.estagiarios.base.ComReatividade.ComRXJava.model.*;
import com.example.estagiarios.base.ComReatividade.ComRXJava.repository.*;

public class PessoaService {
    private final PessoaRepository repository = new PessoaRepository();

    public Single<Pessoa> criarPessoa(Long id, String nome) {
        Pessoa pessoa = new Pessoa(id, nome);
        return repository.salvar(pessoa);
    }

    public Maybe<Pessoa> buscarPessoa(Long id) {
        return repository.buscarPorId(id);
    }

    public Observable<Pessoa> listarPessoas() {
        return repository.listarTodas();
    }

    public Single<Pessoa> atualizarPessoa(Long id, String novoNome) {
        Pessoa pessoaAtualizada = new Pessoa(id, novoNome);
        return repository.atualizar(id, pessoaAtualizada);
    }

    public Completable deletarPessoa(Long id) {
        return repository.deletar(id);
    }
}
