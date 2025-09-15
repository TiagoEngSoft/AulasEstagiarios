package com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.app;

import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.model.*;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.observers.*;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.domain.repository.*;
import com.example.estagiarios.base.ComReatividade.ComPadraoDeProj.Proj02.infrastructure.observadores.*;

import java.util.Arrays;
import java.util.List;

public class Aplicacao {

    public void executar() {
        List<Listner> observaveis = Arrays.asList(
            new AcoesListner(),
            new ResumoDeAcoesListner(),
            new CustoComputacionalListner()
        );
        GerenciadorEventosPessoasPub coreApp = new GerenciadorEventosPessoasPub();
        coreApp.adicionarObservers(observaveis);

        //Interacoes observadas
        coreApp.criar(new Pessoa(1L, "Alice"));
        coreApp.criar(new Pessoa(2L, "Bob"));
        coreApp.criar(new Pessoa(3L, "Belmiro"));

        coreApp.listar().forEach(System.out::println);
        System.out.println();

        coreApp.atualizar(1L, "Alicia");
        coreApp.deletar(2L);

        coreApp.listar().forEach(System.out::println);
    }
}
