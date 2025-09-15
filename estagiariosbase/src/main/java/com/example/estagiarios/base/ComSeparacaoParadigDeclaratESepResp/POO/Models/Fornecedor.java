package com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Models;

import java.io.Serializable;
import java.util.List;

public class Fornecedor implements Serializable {
    private String nomeFornecedor;
    private List<String> nomeProduto;
    private String estado;

    public Fornecedor() {}

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public List<String> getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(List<String> nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    @Override
    public String toString() {
        return "Fornecedor {" +
               "nomeFornecedor='" + nomeFornecedor + '\'' +
               ", nomeProduto=" + nomeProduto +
               ", estado='" + estado + '\'' +
               '}';
    }
}
