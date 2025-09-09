package com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02;

import java.util.List;

import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02.Abs.CadastroFornecedor;
import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02.Abs.CadastroProdutos;
import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02.Impel.GerenciadoCadastros;

public class MainPOOEx02 {
    
    public static void main(String[] args) {
                // Cria uma instância da pipeline de cadastro
        CadastroFornecedor cadastro = new GerenciadoCadastros();

        // 1. Cadastrar o fornecedor
        cadastro
            .setNomeFornecedor("Fornecedor XYZ")
            .setNomeProduto(List.of("Arroz", "Feijão", "Macarrão"))
            .setEstado("SP")
            .salveFornecedor()

        // 2. Cadastrar os produtos um por um
            .setNomeFornecedorPro("Fornecedor XYZ")
            .setNomeProduto("Arroz")
            .setQuantidade(100)
            .salveProduto()

            .setNomeProduto("Feijão")
            .setQuantidade(200)
            .salveProduto()

            .setNomeProduto("Macarrão")
            .setQuantidade(150)
            .salveProduto();
    }
}
