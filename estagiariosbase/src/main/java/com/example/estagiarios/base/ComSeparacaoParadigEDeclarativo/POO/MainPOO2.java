package com.example.estagiarios.base.ComSeparacaoParadigEDeclarativo.POO;

import com.example.estagiarios.base.ComSeparacaoParadigEDeclarativo.POO.Impel.AvaliadorAlunos;

public class MainPOO2 {

    public static void main(String[] args) {
       
        //Conseguimos atingir algo declarativo, alto nivel - Leitura idiomática
        new AvaliadorAlunos()
            .calcularMedia()
            .filtrarRecuperacao()
            .filtrarMedia()
            .filtrarPremio()
            .imprimirResultado();
    }
}
