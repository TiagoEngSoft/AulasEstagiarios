package com.example.estagiarios.base.ComSeparacaoParadigDeclaratESepResp.POO.Abs;

import java.util.List;

public interface CadastroProdutos {
  public CadastroProdutos setNomeFornecedorPro(String fornecedor);
  public CadastroProdutos setNomeProduto(String nomeProduto);
  public CadastroProdutos setQuantidade(Integer quantidade); 
  public CadastroProdutos salveProduto();
}

public interface CadastroFornecedor {
  public CadastroFornecedor setNomeFornecedor(String fornecedor);
  public CadastroFornecedor setNomeProduto(List<String> nomeProduto);
  public CadastroFornecedor setEstado(String estado);
  public CadastroProdutos salveFornecedor();
}
