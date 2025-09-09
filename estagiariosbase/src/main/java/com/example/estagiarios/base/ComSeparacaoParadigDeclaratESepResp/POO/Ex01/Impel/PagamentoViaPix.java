package com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex01.Impel;

import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex01.Abs.*;

public class PagamentoViaPix implements PagamentoPix {

    @Override
    public void pagarComCodigoEstatico(String codigoPix) {
        System.out.println("Pagando com código estático: " + codigoPix);
    }

    @Override
    public void pagarComQRCode(String codigoQRCode) {
        System.out.println("Pagando com QR Code: " + codigoQRCode);
    }

    @Override
    public void pagarComChave(String chave, double valor) {
        System.out.println("Pagando com chave PIX: " + chave + " no valor de R$ " + valor);
    }

    @Override
    public boolean efetuarPagamento(double valor) {
        System.out.println("Efetuando pagamento PIX de R$ " + valor);
        return true;
    }
}
