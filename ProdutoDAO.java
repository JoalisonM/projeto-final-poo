package com.mycompany.gerenciamentoempresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProdutoDAO {
    public void adicionarProduto(Produto produto) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO produto(nome,quantidade,valor,descricao,codigo_categoria,codigo_filial) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, produto.getNome());
            stmt.setInt(2,produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());
            stmt.setString(4, produto.getDescricao());
            stmt.setInt(5, produto.getCodigoCategoria());
            stmt.setInt(6, produto.getCodigoFilial());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public List<Produto> listarProdutos() {
        List<Produto> listaRetorno = new LinkedList<>();
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM produto ORDER BY codigo");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValor(rs.getDouble("valor"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCodigoCategoria(rs.getInt("codigo_categoria"));
                produto.setCodigoFilial(rs.getInt("codigo_filial"));
                
                listaRetorno.add(produto);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        
        return listaRetorno;
    }
    
    public Produto getProdutoPeloCodigo(int codigoProduto) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM funcionario WHERE codigo=?");
            stmt.setInt(1, codigoProduto);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Produto produto = new Produto(rs.getDouble("valor"),rs.getString("nome"),rs.getString("descricao"),rs.getInt("codigo"),
                rs.getInt("quantidade"),rs.getInt("codigo_filial"),rs.getInt("codigo_categoria"));
                return produto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    public void atualizarProduto(Produto produto) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE produto SET nome=?,quantidade=?,valor=?,descricao=?,codigo_categoria=?,codigo_filial=? WHERE codigo=?");
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());
            stmt.setString(4, produto.getDescricao());
            stmt.setInt(5, produto.getCodigoCategoria());
            stmt.setInt(6, produto.getCodigoFilial());
            stmt.setInt(7, produto.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public void deletarProduto(int codigo) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM produto WHERE codigo=?");
            stmt.setInt(1, codigo);

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e);
        } finally {
            postgres.close(null, stmt, conexao);}
    }
}
