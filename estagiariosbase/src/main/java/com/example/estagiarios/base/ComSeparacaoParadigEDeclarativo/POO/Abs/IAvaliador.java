package com.example.estagiarios.base.ComSeparacaoParadigEDeclarativo.POO.Abs;

// Interface que define o contrato (pipeline de métodos)
public interface IAvaliador {
    IAvaliador calcularMedia();
    IAvaliador filtrarRecuperacao();
    IAvaliador filtrarMedia();
    IAvaliador filtrarPremio();
    void imprimirResultado();
}
