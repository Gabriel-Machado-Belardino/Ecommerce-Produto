package br.com.ecommerce.produto.dao;

import br.com.ecommerce.produto.db.DatabaseConnection;
import br.com.ecommerce.produto.entity.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO implements ICategoriaDAO{

    private static CategoriaDAO instance;
    private Connection conexao;

    private CategoriaDAO() {
        this.conexao = DatabaseConnection.getConexao();
    }

    public static CategoriaDAO getInstance() {
        if (instance == null) {
            instance = new CategoriaDAO();
        }
        return instance;
    }

    @Override
    public void salvar(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome_categoria) VALUES (?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar categoria: " + e.getMessage());
        }
    }

    @Override
    public Categoria buscarPorNome(String nomeCategoria) {
        String sql = "SELECT * FROM categoria WHERE nome_categoria = ?";
        Categoria categoria = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nomeCategoria);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria();
                    categoria.setIdCategoria(rs.getInt("id_categoria"));
                    categoria.setNomeCategoria(rs.getString("nome_categoria"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar categoria por nome: " + e.getMessage());
        }

        return categoria;
    }
}