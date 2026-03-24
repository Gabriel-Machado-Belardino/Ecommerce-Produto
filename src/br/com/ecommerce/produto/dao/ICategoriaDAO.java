package br.com.ecommerce.produto.dao;

import br.com.ecommerce.produto.entity.Categoria;

public interface ICategoriaDAO {
    void salvar(Categoria categoria);
    Categoria buscarPorNome(String nomeCategoria);
}
