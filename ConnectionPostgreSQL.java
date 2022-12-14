package com.mycompany.gerenciamentoempresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPostgreSQL {
    private String url, user, password;
    
    public ConnectionPostgreSQL() {
        this.user = "joalison";
        this.password = "12345";
        this.url = "jdbc:postgresql://localhost:5432/postgres";
    }
    
    public Connection getConection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void close(ResultSet rs, PreparedStatement stmt, Connection conexao) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(stmt, conexao);
    }

    public void close(PreparedStatement stmt, Connection conexao) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
