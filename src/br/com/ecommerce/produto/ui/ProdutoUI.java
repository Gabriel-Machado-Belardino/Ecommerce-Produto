package br.com.ecommerce.produto.ui;

import br.com.ecommerce.produto.entity.Categoria;
import br.com.ecommerce.produto.entity.Produto;
import br.com.ecommerce.produto.exception.ProdutoException;
import br.com.ecommerce.produto.service.ProdutoService;

import javax.swing.*;

public class ProdutoUI {

    ProdutoService service = new ProdutoService();


    public void iniciar() {

        while (true) {

            String opcao = JOptionPane.showInputDialog("1 - Cadastrar Categoria\n" + "2 - Cadastrar Produto\n" + "3 - Buscar Produto\n" + "4 - Comparar Produtos\n" + "5 - Atualizar Produto\n" + "6 - Ativar/Desativar Produto\n" + "7 - Sair");

            try {

                switch (opcao) {

                    case "1":

                        String nomeCategoria = JOptionPane.showInputDialog("Nome da categoria:");

                        Categoria categoria = new Categoria();
                        categoria.setNomeCategoria(nomeCategoria);

                        service.cadastrarCategoria(categoria);

                        JOptionPane.showMessageDialog(null, "Categoria cadastrada");

                        break;


                    case "2":

                        String nome = JOptionPane.showInputDialog("Nome do produto:");
                        Double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
                        Integer categoriaId = Integer.parseInt(JOptionPane.showInputDialog("ID Categoria:"));

                        Produto produto = new Produto();

                        produto.setNomeProduto(nome);
                        produto.setPreco(preco);
                        produto.setCategoriaId(categoriaId);
                        produto.setPeso(1.0);

                        service.cadastrarProduto(produto);

                        JOptionPane.showMessageDialog(null, "Produto cadastrado");

                        break;


                    case "3":

                        String busca = JOptionPane.showInputDialog("Nome do produto:");

                        Produto p = service.buscarProduto(busca);

                        JOptionPane.showMessageDialog(null, "Produto: " + p.getNomeProduto() + "\nPreço: " + p.getPreco() + "\nAtivo: " + p.getAtivo());

                        break;


                    case "4":

                        String p1 = JOptionPane.showInputDialog("Produto 1:");
                        String p2 = JOptionPane.showInputDialog("Produto 2:");

                        String resultado = service.compararProdutos(p1, p2);

                        JOptionPane.showMessageDialog(null, resultado);

                        break;


                    case "5":

                        String nomeAtualizar = JOptionPane.showInputDialog("Produto:");
                        Double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo preço"));

                        service.atualizarProduto(nomeAtualizar, novoPreco);

                        JOptionPane.showMessageDialog(null, "Produto atualizado");

                        break;


                    case "6":

                        String nomeStatus = JOptionPane.showInputDialog("Produto:");

                        service.alterarStatusProduto(nomeStatus);

                        JOptionPane.showMessageDialog(null, "Status alterado");

                        break;


                    case "7":

                        return;

                }

            } catch (ProdutoException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        }

    }

}