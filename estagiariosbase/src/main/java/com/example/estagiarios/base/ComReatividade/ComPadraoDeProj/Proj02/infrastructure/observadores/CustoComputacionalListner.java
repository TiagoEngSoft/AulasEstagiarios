package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.infrastructure.observadores;

import java.util.Random;

import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.events.PessoaEvent;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.observers.*;

public class CustoComputacionalListner implements CustoCompListner {
    private final Random random = new Random();

    @Override
    public void novaNotificacao(PessoaEvent evento) {
        acessarCorre();
        tratarInformacoes();

        int custo = random.nextInt(50) + 10;
        System.out.printf("[Custo Computacao] Evento %s para Pessoa %s custou %dms%n",
                evento.getTipo(), evento.getPessoa().getNome(), custo);
    }

    @Override
    public void acessarCorre() {
        //Acessando core S.O
    }

    @Override
    public void tratarInformacoes() {
        //Tratando informacoes core S.O
    }
}
