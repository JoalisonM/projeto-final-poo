package com.mycompany.gerenciamentoempresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO {
    public void adicionarCategoria(Categoria categoria) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO categoria(nome) VALUES(?)");
            stmt.setString(1, categoria.getNome());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public List<Categoria> listarCategorias() {
        List<Categoria> listaRetorno = new LinkedList<>();
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM categoria ORDER BY codigo");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setCodigo(rs.getInt("codigo"));
                categoria.setNome(rs.getString("nome"));
               
                listaRetorno.add(categoria);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        
        return listaRetorno;
    }
    
    public Categoria getCategoriaPeloCodigo(int codigoCategoria) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM categoria WHERE codigo=?");
            stmt.setInt(1, codigoCategoria);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("codigo"),rs.getString("nome"));
                return categoria;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    public void atualizarCategoria(Categoria categoria) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE categoria SET nome=? WHERE codigo=?");
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public void deletarCategoria(int codigo) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM categoria WHERE codigo=?");
            stmt.setInt(1, codigo);

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e);
        } finally {
            postgres.close(null, stmt, conexao);}
    }
}