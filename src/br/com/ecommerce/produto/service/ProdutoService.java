package br.com.ecommerce.produto.service;

import br.com.ecommerce.produto.dao.CategoriaDAO;
import br.com.ecommerce.produto.dao.ProdutoDAO;
import br.com.ecommerce.produto.entity.Categoria;
import br.com.ecommerce.produto.entity.Produto;
import br.com.ecommerce.produto.exception.ProdutoException;

public class ProdutoService {

    private final ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
    private final CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();


    public void cadastrarProduto(Produto produto) throws ProdutoException {

        if (produto.getNomeProduto() == null || produto.getNomeProduto().isEmpty()) {
            throw new ProdutoException("Nome do produto é obrigatório");
        }

        if (produto.getPreco() == null || produto.getPreco() <= 0) {
            throw new ProdutoException("Preço deve ser maior que 0");
        }

        if (produto.getCategoriaId() == null) {
            throw new ProdutoException("Categoria obrigatória");
        }

        produto.setAtivo(false);

        produtoDAO.salvar(produto);
    }


    public void cadastrarCategoria(Categoria categoria) throws ProdutoException {

        if (categoria.getNomeCategoria() == null || categoria.getNomeCategoria().isEmpty()) {
            throw new ProdutoException("Nome da categoria obrigatório");
        }

        Categoria existente = categoriaDAO.buscarPorNome(categoria.getNomeCategoria());

        if (existente != null) {
            throw new ProdutoException("Categoria já existe");
        }

        categoriaDAO.salvar(categoria);
    }


    public Produto buscarProduto(String nome) throws ProdutoException {

        Produto produto = produtoDAO.buscarPorNome(nome);

        if (produto == null) {
            throw new ProdutoException("Produto não encontrado");
        }

        return produto;
    }


    public String compararProdutos(String nome1, String nome2) throws ProdutoException {

        Produto p1 = buscarProduto(nome1);
        Produto p2 = buscarProduto(nome2);

        String resultado = "";

        resultado += "Produto 1: " + p1.getNomeProduto() + "\n";
        resultado += "Produto 2: " + p2.getNomeProduto() + "\n\n";

        if (p1.getPreco().equals(p2.getPreco())) resultado += "Preço: iguais\n";
        else resultado += "Preço: diferentes\n";

        if (p1.getPeso().equals(p2.getPeso())) resultado += "Peso: iguais\n";
        else resultado += "Peso: diferentes\n";

        return resultado;
    }


    public void atualizarProduto(String nome, Double novoPreco) throws ProdutoException {

        Produto produto = buscarProduto(nome);

        if (novoPreco <= 0) {
            throw new ProdutoException("Preço inválido");
        }

        produto.setPreco(novoPreco);
    }


    public void alterarStatusProduto(String nome) throws ProdutoException {

        Produto produto = buscarProduto(nome);

        produto.setAtivo(!produto.getAtivo());

    }

}
