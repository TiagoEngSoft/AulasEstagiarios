package com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Ex02.Models;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nomeFornecedor;
    private String nomeProduto;
    private Integer quantidade;

    public Produto() {}

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto {" +
               "nomeFornecedor='" + nomeFornecedor + '\'' +
               ", nomeProduto='" + nomeProduto + '\'' +
               ", quantidade=" + quantidade +
               '}';
    }
}
