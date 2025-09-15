package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.observers;

import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.events.PessoaEvent;

public interface Listner {
    void novaNotificacao(PessoaEvent evento);
}
