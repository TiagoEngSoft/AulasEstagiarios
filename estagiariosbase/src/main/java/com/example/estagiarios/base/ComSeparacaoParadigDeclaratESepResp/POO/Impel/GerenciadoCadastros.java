package com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02.Impel;

import java.util.List;

import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02.Abs.CadastroFornecedor;
import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02.Abs.CadastroProdutos;
import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02.Models.Fornecedor;
import com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02.Models.Produto;

public class GerenciadoCadastros implements CadastroProdutos, CadastroFornecedor {
    
    private Fornecedor fornecedor;
    private Produto produto;

    public GerenciadoCadastros() {
        this.fornecedor = new Fornecedor();
        this.produto = new Produto();
    }

    // ---------- Implementação da interface CadastroFornecedor ----------

    @Override
    public CadastroFornecedor setNomeFornecedor(String nomeFornecedor) {
        fornecedor.setNomeFornecedor(nomeFornecedor);
        return this;
    }

    @Override
    public CadastroFornecedor setNomeProduto(List<String> nomeProduto) {
        fornecedor.setNomeProduto(nomeProduto);
        return this;
    }

    @Override
    public CadastroFornecedor setEstado(String estado) {
        fornecedor.setEstado(estado);
        return this;
    }

    @Override
    public CadastroProdutos salveFornecedor() {
        System.out.println(fornecedor.toString());
        return this;
    }

    // ---------- Implementação da interface CadastroProdutos ----------

    @Override
    public CadastroProdutos setNomeProduto(String nomeProduto) {
        produto.setNomeProduto(nomeProduto);
        return this;
    }

    @Override
    public CadastroProdutos setQuantidade(Integer quantidade) {
        produto.setQuantidade(quantidade);
        return this;
    }

    @Override
    public CadastroProdutos setNomeFornecedorPro(String nomeFornecedor) {
        produto.setNomeFornecedor(nomeFornecedor);
        return this;
    }

    @Override
    public CadastroProdutos salveProduto() {
        // Aqui você poderia salvar no banco de dados, etc.
        System.out.println(produto.toString());
        return this;
    }
}
