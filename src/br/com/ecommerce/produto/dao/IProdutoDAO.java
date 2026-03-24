package br.com.ecommerce.produto.dao;

import br.com.ecommerce.produto.entity.Produto;

public interface IProdutoDAO {
    void salvar(Produto produto);
    Produto buscarPorNome(String nome);
    void atualizar(Produto produto);
}