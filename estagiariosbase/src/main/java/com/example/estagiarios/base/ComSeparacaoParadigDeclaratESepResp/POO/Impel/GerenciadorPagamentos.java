package com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Impel;

import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Abs.*;

public class GerenciadorPagamentos implements GerenciaFormaPagamento {

    @Override
    public void exibirOpcoes() {
        System.out.println("Opções: PIX, Cartão de Crédito, Cartão de Débito");
    }

    @Override
    public void integrarComAPI(String url) {
        System.out.println("Integrando com API em: " + url);
    }

    @Override
    public boolean processarPagamento(FormaPagamento forma, double valor) {
        System.out.println("Pagamento processado com sucesso!");
        return true;
    }
}

