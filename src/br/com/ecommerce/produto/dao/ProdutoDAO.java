package br.com.ecommerce.produto.dao;

import br.com.ecommerce.produto.db.DatabaseConnection;
import br.com.ecommerce.produto.entity.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO implements IProdutoDAO{

    private static ProdutoDAO instance;
    private Connection conexao;

    private ProdutoDAO() {
        this.conexao = DatabaseConnection.getConexao();
    }

    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
        }
        return instance;
    }

    @Override
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome_produto, descricao_produto, preco, ativo, categoria_id, peso, unidade_medida_peso_id, altura, largura, profundidade, unidade_medida_tamanho_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescricaoProduto());
            stmt.setDouble(3, produto.getPreco() != null ? produto.getPreco() : 0.0);
            stmt.setBoolean(4, produto.getAtivo() != null ? produto.getAtivo() : false);
            stmt.setObject(5, produto.getCategoriaId());
            stmt.setObject(6, produto.getPeso());
            stmt.setObject(7, produto.getUnidadeMedidaPesoId());
            stmt.setObject(8, produto.getAltura());
            stmt.setObject(9, produto.getLargura());
            stmt.setObject(10, produto.getProfundidade());
            stmt.setObject(11, produto.getUnidadeMedidaTamanhoId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar produto: " + e.getMessage());
        }
    }

    @Override
    public Produto buscarPorNome(String nome) {
        String sql = "SELECT * FROM produto WHERE nome_produto = ?";
        Produto produto = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    produto = new Produto();
                    produto.setIdProduto(rs.getLong("id_produto"));
                    produto.setNomeProduto(rs.getString("nome_produto"));
                    produto.setDescricaoProduto(rs.getString("descricao_produto"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setAtivo(rs.getBoolean("ativo"));
                    produto.setCategoriaId(rs.getInt("categoria_id"));
                    produto.setPeso(rs.getDouble("peso"));
                    produto.setUnidadeMedidaPesoId(rs.getInt("unidade_medida_peso_id"));
                    produto.setAltura(rs.getDouble("altura"));
                    produto.setLargura(rs.getDouble("largura"));
                    produto.setProfundidade(rs.getDouble("profundidade"));
                    produto.setUnidadeMedidaTamanhoId(rs.getInt("unidade_medida_tamanho_id"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto por nome: " + e.getMessage());
        }

        return produto;
    }

    @Override
    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET preco = ?, ativo = ? WHERE id_produto = ?"; // Atualizando os campos usados no Service

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDouble(1, produto.getPreco());
            stmt.setBoolean(2, produto.getAtivo());
            stmt.setLong(3, produto.getIdProduto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }
}