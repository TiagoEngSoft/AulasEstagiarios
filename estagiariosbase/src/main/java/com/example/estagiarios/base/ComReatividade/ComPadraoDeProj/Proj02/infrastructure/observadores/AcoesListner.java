package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.infrastructure.observadores;

import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.events.PessoaEvent;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.observers.*;

public class AcoesListner implements AcaoListner {
    @Override
    public void novaNotificacao(PessoaEvent evento) {
        
        interPretandoAcao();
        validandoAcao();

        switch (evento.getTipo()) {
            case CRIADA:
                System.out.println("[Acao] Pessoa criada: " + evento.getPessoa());
                break;
            case ATUALIZADA:
                System.out.println("[Acao] Pessoa atualizada: " + evento.getPessoa());
                break;
            case DELETADA:
                System.out.println("[Acao] Pessoa deletada: " + evento.getPessoa());
                break;
        }
    }

    @Override
    public void interPretandoAcao() {
        //Interpretando regra e carregando Abs acao
    }

    @Override
    public void validandoAcao() {
        //Validando acao para partes destinadas no S.O
    }
}
