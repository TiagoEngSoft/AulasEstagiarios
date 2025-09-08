package com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Impel;

import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Abs.*;

public class PagamentoViaCartao implements PagamentoCartao {

    private String tipoOperacao;
    private String numeroCartao;
    private String validade;
    private String codigoSeguranca;
    private String nomeTitular;
    private String documento;

    @Override
    public void definirTipoOperacao(String tipo) {
        this.tipoOperacao = tipo;
    }

    @Override
    public void informarDadosCartao(String numero, String validade, String codigoSeguranca) {
        this.numeroCartao = numero;
        this.validade = validade;
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public void informarDadosTitular(String nome, String documento) {
        this.nomeTitular = nome;
        this.documento = documento;
    }

    @Override
    public boolean efetuarPagamento(double valor) {
        // Validação simples (mock)
        if (numeroCartao == null || nomeTitular == null || tipoOperacao == null) {
            System.out.println("Dados do cartão incompletos.");
            return false;
        }

        System.out.println("Processando pagamento com cartão...");
        System.out.println("Tipo: " + tipoOperacao);
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Valor: R$ " + valor);
        return true;
    }
}
