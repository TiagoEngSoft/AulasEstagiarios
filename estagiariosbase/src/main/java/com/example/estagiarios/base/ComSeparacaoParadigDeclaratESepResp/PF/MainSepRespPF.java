package com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.PF;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainSepRespPF {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        

        // Pagamento com PIX ********************************
        Map<String, Object> pix = criarPagamentoViaPix();
        ((Consumer<String>) pix.get("pagarComCodigoEstatico")).accept("COD-PIX-123");
        ((Consumer<String>) pix.get("pagarComQRCode")).accept("QR123456");
        ((BiConsumer<String, Double>) pix.get("pagarComChave")).accept("joao@banco.com", 150.00);
        boolean sucessoPix = ((Function<Double, Boolean>) pix.get("efetuarPagamento")).apply(150.00);
        System.out.println("Pagamento foi bem-sucedido? " + sucessoPix);

        // Pagamento com Cartão ********************************
        Map<String, Object> cartao = criarPagamentoCartao();
        ((Consumer<String>) cartao.get("definirTipoOperacao")).accept("crédito");

        Map<String, String> dadosCartao = new HashMap<>();
        dadosCartao.put("numero", "1234 5678 9012 3456");
        dadosCartao.put("validade", "12/30");
        dadosCartao.put("cvv", "123");
        ((Consumer<Map<String, String>>) cartao.get("informarDadosCartao")).accept(dadosCartao);

        Map<String, String> dadosTitular = new HashMap<>();
        dadosTitular.put("nome", "João da Silva");
        dadosTitular.put("documento", "123.456.789-00");
        ((Consumer<Map<String, String>>) cartao.get("informarDadosTitular")).accept(dadosTitular);

        boolean sucessoCartao = ((Function<Double, Boolean>) cartao.get("efetuarPagamento")).apply(250.0);
        System.out.println("Pagamento foi bem-sucedido? " + sucessoCartao);
    }

    // ======= Closure que representa o "Pagamento no cartao" =======================================================
    public static Map<String, Object> criarPagamentoCartao() {
        // Estado interno encapsulado via closure
        final String[] tipoOperacao = new String[1];
        final String[] numeroCartao = new String[1];
        final String[] validade = new String[1];
        final String[] codigoSeguranca = new String[1];
        final String[] nomeTitular = new String[1];
        final String[] documento = new String[1];

        Map<String, Object> cartao = new HashMap<>();

        // Define tipo de operação
        Consumer<String> definirTipoOperacao = tipo -> tipoOperacao[0] = tipo;

        // Informar dados do cartão via Map
        Consumer<Map<String, String>> informarDadosCartao = dados -> {
            numeroCartao[0] = dados.get("numero");
            validade[0] = dados.get("validade");
            codigoSeguranca[0] = dados.get("cvv");
        };

        // Informar dados do titular via Map
        Consumer<Map<String, String>> informarDadosTitular = dados -> {
            nomeTitular[0] = dados.get("nome");
            documento[0] = dados.get("documento");
        };

        // Efetuar pagamento
        Function<Double, Boolean> efetuarPagamento = valor -> {
            if (numeroCartao[0] == null || nomeTitular[0] == null || tipoOperacao[0] == null) {
                System.out.println("Dados do cartão incompletos.");
                return false;
            }

            System.out.println("Processando pagamento com cartão...");
            System.out.println("Tipo: " + tipoOperacao[0]);
            System.out.println("Titular: " + nomeTitular[0]);
            System.out.println("Valor: R$ " + valor);
            return true;
        };

        // Adiciona funções ao "objeto funcional"
        cartao.put("definirTipoOperacao", definirTipoOperacao);
        cartao.put("informarDadosCartao", informarDadosCartao);
        cartao.put("informarDadosTitular", informarDadosTitular);
        cartao.put("efetuarPagamento", efetuarPagamento);

        return cartao;
    }

     // ======= Closure que representa o "Pagamento no cartao" =======================================================
     public static Map<String, Object> criarPagamentoViaPix() {
        Map<String, Object> pix = new HashMap<>();

        // Simula método: pagarComCodigoEstatico
        Consumer<String> pagarComCodigoEstatico = codigo -> {
            System.out.println("Pagando com código estático: " + codigo);
        };

        // Simula método: pagarComQRCode
        Consumer<String> pagarComQRCode = qrCode -> {
            System.out.println("Pagando com QR Code: " + qrCode);
        };

        // Simula método: pagarComChave
        BiConsumer<String, Double> pagarComChave = (chave, valor) -> {
            System.out.println("Pagando com chave PIX: " + chave + " no valor de R$ " + valor);
        };

        // Simula método: efetuarPagamento
        Function<Double, Boolean> efetuarPagamento = valor -> {
            System.out.println("Efetuando pagamento PIX de R$ " + valor);
            return true;
        };

        // Adiciona funções no "objeto funcional"
        pix.put("pagarComCodigoEstatico", pagarComCodigoEstatico);
        pix.put("pagarComQRCode", pagarComQRCode);
        pix.put("pagarComChave", pagarComChave);
        pix.put("efetuarPagamento", efetuarPagamento);

        return pix;
    }

}

