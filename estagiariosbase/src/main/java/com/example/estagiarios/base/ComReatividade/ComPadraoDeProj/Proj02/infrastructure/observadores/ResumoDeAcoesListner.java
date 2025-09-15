package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.infrastructure.observadores;

import java.util.EnumMap;

import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.events.PessoaEvent;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.observers.*;

public class ResumoDeAcoesListner implements ResumoAcaoListner {

    private final EnumMap<PessoaEvent.Tipo, Integer> contador = new EnumMap<>(PessoaEvent.Tipo.class);

    public ResumoDeAcoesListner() {
        for (PessoaEvent.Tipo tipo : PessoaEvent.Tipo.values()) {
            contador.put(tipo, 0);
        }
    }

    @Override
    public void novaNotificacao(PessoaEvent evento) {
        contador.put(evento.getTipo(), contador.get(evento.getTipo()) + 1);
        montarResumo();
        mostrarResumo();
    }
    

    @Override
    public void montarResumo() {
        //Codigo para montagem de resumo - Dll ou Api, vai saber ..
    }

    @Override
    public void mostrarResumo() {
        System.out.println("[Resumo] Eventos registrados:");
        contador.forEach((tipo, count) -> System.out.printf("  %s: %d%n", tipo, count));
    }

    
}
