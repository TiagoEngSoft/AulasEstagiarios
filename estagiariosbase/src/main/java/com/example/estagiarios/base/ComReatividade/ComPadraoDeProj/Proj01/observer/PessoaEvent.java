package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj01.observer;

import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj01.model.*;

public class PessoaEvent {
    public enum Tipo {
        CRIADA,
        ATUALIZADA,
        DELETADA
    }

    private final Tipo tipo;
    private final Pessoa pessoa;

    public PessoaEvent(Tipo tipo, Pessoa pessoa) {
        this.tipo = tipo;
        this.pessoa = pessoa;
    }

    public Tipo getTipo() { return tipo; }
    public Pessoa getPessoa() { return pessoa; }
}
