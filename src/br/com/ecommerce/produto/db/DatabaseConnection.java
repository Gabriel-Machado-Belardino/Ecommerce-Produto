package br.com.ecommerce.produto.db;

import java.sql.*;

public class DatabaseConnection {
    private String url;
    private String user;
    private String password;
    private static Connection connection;
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        this.url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
        this.user = "*****";
        this.password = "******";
        this.init();
    }

    private void init(){
        if(connection != null) return;
        try{
            connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch(SQLException e){
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConexao() {
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return connection;
    }
}